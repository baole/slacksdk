package com.anttek.tool

import org.apache.commons.io.FileUtils
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * one-time code generator
 */
class SlackCallback {
    private var jsonSchemaFile: String? = null
    private var modelPackageName: String? = null
    private var outputDir: String? = null
    private var outputDirFile: File? = null
    private fun setJsonSchemaFile(jsonSchemaFile: String?) {
        this.jsonSchemaFile = jsonSchemaFile
    }

    private fun setPackageName(packageName: String) {
        modelPackageName = "$packageName.model"
        this.packageName = packageName
    }

    private fun setOutputDir(outputDir: String) {
        this.outputDir = outputDir
    }

    private val definitionMap: HashMap<String, DefItem> = HashMap()
    private val missingDefinition: ArrayList<String> = ArrayList()
    private lateinit var packageName: String
    @Throws(IOException::class)
    fun generateWithDefault(schemaPath: String) {
        setJsonSchemaFile(schemaPath)
        setOutputDir("slack-callback/src/main/java")
        setPackageName("com.anttek.slack.callback")
        val src = File(outputDir, packageName.replace(".", "/"))
        FileUtils.deleteDirectory(File(src, "model"))
        val jsonObject = JSONObject(readFile(jsonSchemaFile))
        generateDefinitions(jsonObject)
    }

    private fun resolveType(json: JSONObject?, recursive: Boolean = true): Type? {
        var dataType: String? = "Any"
        var kind = TYPE_OBJECT
        var targetKind = KIND_CLASS
        var isPrimitive = false
        var typeStr: String? = null
        if (json!!.has("\$ref")) {
            dataType = json.getString("\$ref")
            dataType = dataType.replace("#/components/schemas/", "")
            if (dataType.startsWith("defs_")) {
                typeStr = defTypeMap!![dataType]
            }
        } else if (json.has("type")) {
            try {
                typeStr = json.getString("type")
            } catch (e: Throwable) {
                System.err.println(json.toString(4))
                return null
            }
        }
        if (typeStr != null) {
            if ("string" == typeStr) {
                dataType = "String"
                isPrimitive = true
            } else if ("boolean" == typeStr || "Boolean" == typeStr) {
                dataType = "Boolean"
                isPrimitive = true
            } else if ("integer" == typeStr) {
                dataType = "Long"
                isPrimitive = true
            } else if ("number" == typeStr) {
                dataType = "Double"
                isPrimitive = true
            } else if ("object" == typeStr) {
                dataType = "Any"
                System.err.println("Warning: resolveType: too generic Object/$json")
            } else if ("array" == typeStr) {
                kind = TYPE_ARRAY_OBJECT
                if (recursive) {
                    dataType = if (json.has("items")) {
                        val jsonItems: JSONObject? = json.getJSONObject("items")
                        resolveType(jsonItems, false)!!.fullType
                    } else {
                        "Any"
                    }
                } else {
                    System.err.println("Warning: resolveType: unknow type: $typeStr/$json")
                    return null
                }
            } else {
                System.err.println("Warning: resolveType: unknow type: $typeStr/$json")
            }
        } else if (json.has("\$ref")) {
            dataType = json.getString("\$ref")
            dataType = dataType.replace("#/components/schemas/", "")
        } else {
            System.err.println("Warning: resolveType: unknow type: $json")
        }
        val type = Type(makeClassName(dataType), kind)
        type.targetKind = targetKind
        type.isPrimative = isPrimitive
        if (json.has("in")) type.`in` = json.getString("in")
        if (json.has("name")) type.name = json.getString("name")
        return type
    }

    ///------------- definitions ------------
    internal var defTypeMap: MutableMap<String?, String?>? = HashMap()

    @Throws(IOException::class)
    private fun generateDefinitions(jsonObject: JSONObject) {
        val jsonDefinitions = jsonObject.getJSONObject("components").getJSONObject("schemas")
        for (key in jsonDefinitions.keySet()) {
            addToMissingDefinition(key, jsonDefinitions.getJSONObject(key))
            generateClass(definitionMap[key])
        }
        val jsonTopics = jsonObject.getJSONObject("topics")
        for (key in jsonTopics.keySet()) {
            val jsonPayload = jsonTopics.getJSONObject(key).getJSONObject("subscribe").getJSONObject("payload")
            if (!jsonPayload.has("\$ref")) {
                addToMissingDefinition(key.replace(".", "_"), jsonPayload)
                generateClass(definitionMap[key])
            }
        }

        var keys = ArrayList(definitionMap.keys)
        do {
            for (key in keys) {
                if (DEBUG) {
                    println(key + " / " + definitionMap[key]!!.kind)
                }
                generateClass(definitionMap[key])
            }
            keys = ArrayList(missingDefinition)
            missingDefinition.clear()
        } while (keys.size > 0)

        for (key in jsonTopics.keySet()) {
            println("const val EVENT_${key.replace(".", "_").toUpperCase()} = \"$key\"")
        }
    }

    @Throws(IOException::class)
    private fun generateClass(item: DefItem?) {
        if (item == null) {
            return
        }
        println("Generate class: " + item.key)
        prepareDefinition(item)
        val classname = makeClassName(item.key)
        val ps = PrintStream(FileOutputStream(File(outputDirFile, "$classname.kt")))
        writeClassPackage(ps, item)
        writeClassImport(ps, item)
        writeClassDescription(ps, item)
        openClass(ps, item, classname)
        val required = ArrayList<String?>()
        if (item.json.has("required")) {
            val jsonArray: JSONArray? = item.json.getJSONArray("required")
            val length = jsonArray!!.length()
            for (i in 0 until length) {
                required.add(jsonArray.getString(i))
            }
        }
        if (item.json.has("properties")) {
            val jsonProperties: JSONObject? = item.json.getJSONObject("properties")
            var isFirst = true
            for (key in jsonProperties!!.keySet()) {
                val jsonProp: JSONObject? = jsonProperties.getJSONObject(key)
                if (jsonProp!!.has("additionalProperties")) {
                    var childKey: String
                    childKey = if (item.isRequest) {
                        item.key + "_" + key
                    } else {
                        item.key.replace("Response", "") + "_" + key + "Response"
                    }
                    val childItem = addToMissingDefinition(childKey, jsonProp)
                    if (childItem != null) {
                        generateClass(childItem)
                    }
                }
                writeClassProperty(ps, classname, key, jsonProp, required, isFirst, item.isRequest)
                isFirst = false
            }
        }
        closeClass(ps)
        ps.close()
    }

    private fun writeClassProperty(ps: PrintStream?, classname: String?, key: String?, jsonAttrs: JSONObject?, required: ArrayList<String?>?, isFirst: Boolean, isModel: Boolean) {
        val type = if (jsonAttrs!!.has("additionalProperties")) {
            if (isModel) {
                Type(classname + makeClassName(key), TYPE_OBJECT)
            } else {
                Type(classname!!.replace("Response", "") + makeClassName(key) + "Response", TYPE_OBJECT)
            }
        } else {
            resolveType(jsonAttrs)
        }
        if (type == null) return
        val fieldType = makeClassName(type.fullType)
        val desc = if (jsonAttrs.has("description")) jsonAttrs.getString("description") else null
        val isRequired = required!!.contains(key)
        if (desc != null) {
            val deprecated = desc.contains("DEPRECATED") || desc.contains("deprecated")
            if (deprecated) {
                printString(ps, "   /** @deprecated %s */", desc)
                printString(ps, "   @Deprecated")
            } else {
                printString(ps, "   /** %s */", desc)
            }
        }
        val fieldName = makeFieldName(key)
        printString(ps, if (isFirst) "" else ",")
        printStringS(ps, "    var %s: %s%s", fieldName, fieldType, if (isRequired) "" else "? = null")
    }

    private fun addToMissingDefinition(key: String, json: JSONObject): DefItem? {
        if (definitionMap.containsKey(key)) {
            return null
        }
        val kind = KIND_CLASS
        if (DEBUG) {
            println("add def $key/class / $json")
        }
        val item = DefItem()
        item.key = key
        item.json = json
        item.kind = kind
        definitionMap[key] = item
        missingDefinition.add(key)
        return item
    }

    @Throws(IOException::class)
    private fun prepareDefinition(item: DefItem?) {
        outputDirFile = File(outputDir + File.separator + modelPackageName!!.replace('.', '/'))
        outputDirFile!!.mkdirs()
    }

    private fun closeClass(ps: PrintStream?) {
        ps!!.println()
        ps.println(")")
    }

    private fun openClass(ps: PrintStream?, item: DefItem?, classname: String?) {
        printStringS(ps, "%sclass %s (", if (item!!.isRequest) "" else "", classname)
    }

    private fun printString(ps: PrintStream?, string: String?, vararg args: String?) {
        ps!!.println(String.format(string!!, *args))
    }

    private fun printString(ps: PrintStream?) {
        ps!!.println()
    }

    private fun printStringS(ps: PrintStream?, string: String?, vararg args: String?) {
        ps!!.print(String.format(string!!, *args))
    }

    private fun writeClassDescription(ps: PrintStream?, item: DefItem?) {
        val deprecated_ = if (item!!.json.has("_deprecated")) item.json.getString("_deprecated") else null
        val description = if (item.json.has("description")) item.json.getString("description") else null
        val isDeprecated = deprecated_ != null || description != null && (description.contains("DEPRECATED") ||
                description.contains("deprecated"))
        if (isDeprecated) {
            ps!!.println("@Deprecated")
        }
    }

    private fun writeClassImport(ps: PrintStream?, item: DefItem?) {
        if (item!!.isRequest) {
        } else {
            printString(ps, "import %s.model.*", packageName)
        }
        ps!!.println()
    }

    private fun writeClassPackage(ps: PrintStream, item: DefItem?) {
        ps.println("package $modelPackageName")
    }

    private fun makeClassName(action: String?): String {
        var action = action
        return try {
            if (action!!.startsWith("#/definitions/")) {
                action = action.substring(14)
            }
            if (action.startsWith("objs_")) {
                action = action.substring(5)
            }
            var name = action.substring(0, 1).toUpperCase() + action.substring(1, action.length)
            var _index = name.indexOf("_")
            while (_index >= 0) {
                name = name.substring(0, _index) + name.substring(_index + 1, _index + 2).toUpperCase() + name.substring(_index + 2, name.length)
                _index = name.indexOf("_")
            }
            if (isNumeric(name)) {
                name = "_$name"
            }
            name
        } catch (e: Throwable) {
            System.err.println("Error: Cannot formalize classname for $action")
            action!!
        }
    }

    private fun makeFieldName(input: String?): String? {
        val name = makeClassName(input)
        return name!!.substring(0, 1).toLowerCase() + name.substring(1)
    }

    @Throws(IOException::class)
    private fun readFile(path: String?): String? {
        val file = File(javaClass.classLoader.getResource(path).file)
        println(file.absolutePath)
        val encoded: ByteArray? = Files.readAllBytes(Paths.get(file.absolutePath))
        return String(encoded!!, Charsets.UTF_8)
    }

    companion object {
        var TYPE_OBJECT = 0
        private const val TYPE_ARRAY_OBJECT = 1
        private const val KIND_CLASS = 1
        private const val DEBUG = true
        fun isNumeric(str: String?): Boolean {
            return str!!.matches(Regex("-?\\d+(\\.\\d+)?"))  //match a number with optional '-' and decimal.
        }

        @JvmStatic
        fun main(args: Array<String>) {
            SlackCallback().generateWithDefault("slack_events_api_async_v1.json")
        }
    }
}
