/*
 * Copyright (c) 2016, 2017, 2018, 2019. Tandem. All rights reserved.
 *
 */

package com.anttek.tool

import org.apache.commons.io.FileUtils
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 *
 */
class SlackCallback {

    private var jsonSchemaFile: String? = null
    private var modelPackageName: String? = null
    private var responsePackageName: String? = null
    private var outputDir: String? = null
    private var outputDirFile: File? = null
    private fun setJsonSchemaFile(jsonSchemaFile: String?) {
        this.jsonSchemaFile = jsonSchemaFile
    }

    private fun setPackageName(packageName: String?) {
        modelPackageName = "$packageName.model"
        responsePackageName = "$packageName.response"
        this.packageName = packageName
    }

    private fun setOutputDir(outputDir: String?) {
        this.outputDir = outputDir
    }

    private val definitionMap: HashMap<String?, DefItem?>? = HashMap()
    private val missingDefinition: ArrayList<String?>? = ArrayList()
    private val intEnumClaszz: ArrayList<String?>? = ArrayList()
    private var packageName: String? = null
    @Throws(IOException::class)
    fun generateWithDefault(schemaPath: String?) {
        setJsonSchemaFile(schemaPath)
        setOutputDir("slack-callback/src/main/java")
        val packagePrefix = "com.anttek.slack"
        setPackageName(packagePrefix)
        val src = File(outputDir, packagePrefix.replace(".", "/"))
        FileUtils.deleteDirectory(File(src, "model"))
        FileUtils.deleteDirectory(File(src, "response"))
        FileUtils.deleteDirectory(File(src, "request"))
        val jsonObject = JSONObject(readFile(jsonSchemaFile))
        generateDefinitions(jsonObject)
        generateApis(jsonObject)
    }

    @Throws(IOException::class)
    private fun generateApis(jsonObject: JSONObject?) {
        prepareAction()
        val jsonPaths: JSONObject? = jsonObject!!.getJSONObject("paths")
        val outdir = File(outputDirFile, packageName!!.replace(".", "/"))
        outdir.mkdirs()
        val ps = PrintStream(FileOutputStream(File(outdir, "SlackService.kt")))
        writeActionClassPackage(ps)
        writeActionClassImport(ps)
        printString(ps, "interface SlackService {")
        val psa = PrintStream(FileOutputStream(File(outdir, "SlackApi.kt")))
        writeActionClassPackage(psa)
        printString(psa, "import com.anttek.slack.request.*")
        printString(psa, "import com.anttek.slack.response.*")
        printString(psa)
        printString(psa, "class SlackApi(private val service: SlackService, private val mapper: Mapper, private var token: String = \"\") : BaseSlackApi() {")
        printString(psa, "    fun token(token: String): SlackApi {")
        printString(psa, "         this.token = token")
        printString(psa, "        return this")
        printString(psa, "    }")
        printString(psa)
        printString(psa, "    private fun authen() = \"Bearer \$token\"")
        printString(psa)
        for (key in jsonPaths!!.keySet()) {
            generateMethod(ps, psa, key, jsonPaths.getJSONObject(key))
        }
        printString(ps, "}")
        printString(psa, "}")
    }

    @Throws(IOException::class)
    private fun generateMethod(ps: PrintStream?, psa: PrintStream?, key: String?, json: JSONObject?) {
        if (json!!.has("get")) {
            generateMethod(ps, psa, key, json.getJSONObject("get"), true)
        }
        if (json.has("post")) {
            generateMethod(ps, psa, key, json.getJSONObject("post"), false)
        }
    }

    @Throws(IOException::class)
    private fun generateMethod(ps: PrintStream?, psa: PrintStream?, key: String?, json: JSONObject?, isGet: Boolean) {
        val title: String? = json!!.getString("operationId")
        val classname = makeClassName(title + "Response")
        val jsonParams: JSONArray? = json.getJSONArray("parameters")
        printString(ps, "    @%s(\"%s\")", getHttpMethod(isGet), key!!.substring(1))
        printStringS(ps, "    fun %s(", makeFieldName(title))
        val name = makeClassName(key.substring(1).replace(".", "_")) + "Request"
        printStringS(psa, "    fun %s(", makeFieldName(title))
        if (isGet) {
//            printStringS(ps, "@QueryMap request: %s", name);

        } else {
            printStringS(ps, "@Header(\"Authorization\") authorization: String, @Body request: %s", name)
            printString(ps, "): Call<%s>", classname)
            printString(ps, "")
            printString(psa, "request: %s): SlackResponse<%s> {", makeClassName(title) + "Request", makeClassName(title) + "Response")
        }
        val paramCount = jsonParams!!.length()
        val params = ArrayList<RetrofitParam?>()
        for (i in 0 until paramCount) {
            val type = resolveType(jsonParams.getJSONObject(i))
            if (type!!.`in` == "query" || type.`in` == "formData") {
                params.add(RetrofitParam(type.name, type.type, "Query"))
            } else if (type.`in` == "header") {
                params.add(RetrofitParam(type.name, type.type, "Header"))
            } else {
                System.err.println("Warning: resolveType: retrofit param " + type.`in`)
            }
        }
        var hasToken = false
        val pr = ArrayList<RetrofitParam?>()
        for (param in params) {
            if (param!!.annoType == "Header" || param.typeName == "token") {
                if (isGet) {
                    pr.add(param)
                }
                hasToken = true
            }
        }
        for (param in params) {
            if ("token" != param!!.typeName && "cursor" != param.typeName && "limit" != param.typeName) {
                param.isNull = true
                pr.add(param)
            }
        }
        for (param in params) {
            if ("cursor" == param!!.typeName || "limit" == param.typeName) {
                param.isNull = true
                pr.add(param)
            }
        }
        if (isGet) {
            var isFirst = true
            var isApiFirst = true
            val paramsList = StringBuilder()
            for (param in pr) {
                if (!isFirst) {
                    printString(ps, ",")
                    printStringS(ps, "                                ")
                }
                if (!isApiFirst) {
                    printString(psa, ",")
                    printStringS(psa, "                                ")
                }
                printStringS(ps, "@Query(\"%s\") %s: %s%s",
//                    param.getAnnoType(),
                        param!!.typeName, makeFieldName(param.typeName), param.returnType, if (param.isNull) "? = null" else "")
                if ("token" != param.typeName) {
                    printStringS(psa, "%s: %s%s", makeFieldName(param.typeName), param.returnType, if (param.isNull) "? = null" else "")
                    if (!isApiFirst || hasToken) {
                        paramsList.append(", ")
                    }
                    paramsList.append(makeFieldName(param.typeName))
                    isApiFirst = false
                }
                isFirst = false
            }
            printString(ps, "): Call<%s>", classname)
            printString(ps, "")
            printString(psa, "): SlackResponse<%s> {", classname)
            printString(psa, "        return getResponse(service.%s(%s%s))", makeFieldName(title), if (hasToken) "token" else "", paramsList.toString())
            printString(psa, "    }")
        } else {
            generateActionRequestClass(key, json, isGet, pr)
            printString(psa, "        return getResponse(service.%s(authen(), request))", makeFieldName(title))
            printString(psa, "    }")
        }
        printString(psa)
    }

    @Throws(IOException::class)
    private fun generateActionRequestClass(key: String?, json: JSONObject?, isGet: Boolean, params: ArrayList<RetrofitParam?>?) {
        val classname = makeClassName(key!!.substring(1).replace(".", "_")) + "Request"
        val outdir = File(outputDirFile, packageName!!.replace(".", "/") + "/request")
        outdir.mkdirs()
        val ps = PrintStream(FileOutputStream(File(outdir, "$classname.kt")))
        printString(ps, "package com.anttek.slack.request")
        printString(ps, "")
        printStringS(ps, "%sclass %s (", if (params!!.size > 0) "data " else "", classname)
        var isFirst = true
        for (param in params) {
            printString(ps, if (isFirst) "" else ",")
            printStringS(ps, "        ")
            printStringS(ps, "val %s: %s%s", param!!.typeName, param.returnType, if (param.isNull) "? = null" else "")
            isFirst = false
        }
        printString(ps, "")
        printString(ps, ")")
        ps.close()
    }

    private fun getHttpMethod(isGet: Boolean): String? {
        return if (isGet) "GET" else "POST"
    }

    private fun getMethodPrefix(isGet: Boolean): String? {
        return if (isGet) "get" else "post"
    }

    private fun writeActionClassPackage(ps: PrintStream?) {
        ps!!.print("package ")
        ps.print(packageName)
        ps.println()
    }

    private fun resolveType(json: JSONObject?, recursive: Boolean = true): Type? {
        var dataType: String? = "Any"
        var kind = TYPE_OBJECT
        var targetKind = KIND_CLASS
        var isPrimitive = false
        var typeStr: String? = null
        if (json!!.has("\$ref")) {
            dataType = json.getString("\$ref")
            dataType = dataType.replace("#/definitions/", "")
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
            dataType = dataType.replace("#/definitions/", "")
            val className = makeClassName(dataType)
            if (definitionMap!!.containsKey(dataType) && definitionMap[dataType]!!.kind == KIND_ENUM) {
                targetKind = KIND_ENUM
            }
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

    private fun writeActionClassImport(ps: PrintStream?) {
        ps!!.println("import $packageName.model.*")
        ps.println("import com.anttek.slack.request.*")
        ps.println("import com.anttek.slack.response.*")
        ps.println("import retrofit2.Call")
        ps.println("import retrofit2.http.Header")
        ps.println("import retrofit2.http.GET")
        ps.println("import retrofit2.http.POST")
        ps.println("import retrofit2.http.Query")
        ps.println("import retrofit2.http.Body")
        ps.println("import retrofit2.http.QueryMap")
        ps.println()
    }

    ///------------- definitions ------------
    internal var defTypeMap: MutableMap<String?, String?>? = HashMap()

    @Throws(IOException::class)
    private fun generateDefinitions(jsonObject: JSONObject?) {
        val jsonDefinitions: JSONObject? = jsonObject!!.getJSONObject("definitions")
        for (key in jsonDefinitions!!.keySet()) {
            val jsonDefinition: JSONObject? = jsonDefinitions.getJSONObject(key)
            if (key!!.startsWith("defs_")) {
                defTypeMap!![key] = jsonDefinition!!.getString("type")
            } else {
                addToMissingDefinition(key, jsonDefinition, true)
                generateClass(definitionMap!![key])
            }
        }
        val jsonPaths: JSONObject? = jsonObject.getJSONObject("paths")
        for (key in jsonPaths!!.keySet()) {
            val jsonPath: JSONObject? = jsonPaths.getJSONObject(key)
            if (jsonPath!!.has("get")) {
                generateResponseObject(key, jsonPath.getJSONObject("get"), true)
            }
            if (jsonPath.has("post")) {
                generateResponseObject(key, jsonPath.getJSONObject("post"), false)
            }
        }
        var keys = ArrayList(definitionMap!!.keys)
        do {
            for (key in keys) {
                if (DEBUG) {
                    println(key + " / " + definitionMap[key]!!.kind)
                }
                val item = definitionMap[key]
                if (item!!.kind == KIND_ENUM) {
                    generateEnum(item)
                } else {
                    generateClass(item)
                }
            }
            keys = ArrayList(missingDefinition)
            missingDefinition!!.clear()
        } while (keys.size > 0)
    }

    @Throws(IOException::class)
    private fun generateResponseObject(key: String?, json: JSONObject?, isGet: Boolean) {
        val jsonSchema: JSONObject? = json!!.getJSONObject("responses").getJSONObject("200").getJSONObject("schema")
        val newKey = json.getString("operationId") + "_" + "Response"
        addToMissingDefinition(newKey, jsonSchema, false)
        generateClass(definitionMap!![newKey])
    }

    @Throws(FileNotFoundException::class)
    private fun generateEnum(item: DefItem?) {
        val classname = makeClassName(item!!.key)
        val isIntVal = "integer" == item.json.getString("type")
        val type = if (isIntVal) "int" else "String"
        val ps = PrintStream(FileOutputStream(File(outputDirFile, "$classname.kt")))
        writeClassPackage(ps, item)
        writeClassImport(ps, item)
        writeClassDescription(ps, item)
        if (isIntVal) {
            if (!intEnumClaszz!!.contains(classname)) {
                intEnumClaszz.add(classname)
            }
        }
        openEnum(ps, classname, isIntVal)
        val enums: JSONArray? = item.json.getJSONArray("enum")
        var first = true
        val length = enums!!.length()
        val creator = StringBuilder()
        try {
            for (i in 0 until length) {
                if (first) {
                    first = false
                } else {
                    ps.println(",")
                }
                var name: String? = null
                try {
                    name = enums.getString(i)
                } catch (e: Throwable) {
                    //ignored

                }
                if (name == null) {
                    try {
                        name = enums.getInt(i).toString()
                    } catch (e: Throwable) {
                        //ignored

                        System.err.println(enums.toString(4))
                    }
                }
                var upperName = makeClassName(name!!.toUpperCase())
                upperName = makeEnumField(upperName)
                ps.print("      @SerializedName(\"")
                ps.print(name)
                ps.print("\")")
                if (isIntVal) {
                    ps.print("$upperName($name)")
                } else {
                    ps.print("$upperName(\"$name\")")
                }
                if (isIntVal) {
                    creator.append("    if(").append(upperName).append(".value == value){").append("\n")
                            .append("       return ").append(upperName).append(";").append("\n")
                            .append("       }").append("\n")
                } else {
                    creator.append("    if(").append(upperName).append(".value.equals(value)){").append("\n")
                            .append("       return ").append(upperName).append(";").append("\n")
                            .append("       }").append("\n")
                }
            }
        } catch (e: Throwable) {
            System.err.println(enums.toString(4))
            ps.println("//ERROR ")
//            throw new RuntimeException(e);

        }
        ps.println(";")
        printString(ps, "public static %s create(%s value) {%s \n         return null;}",
                makeClassName(classname), type, creator.toString())
        closeEnum(ps, classname, isIntVal)
        ps.close()
    }

    private fun makeEnumField(name: String?): String? {
        var name = name
        name = name!!.replace("-", "_")
        return name
    }

    private fun openEnum(ps: PrintStream?, classname: String?, isIntVal: Boolean) {
        printString(ps, "public enum %s %s{", classname, if (isIntVal) "implements IntEnum" else "")
    }

    private fun closeEnum(ps: PrintStream?, classname: String?, isIntVal: Boolean) {
        val type = if (isIntVal) "int" else "String"
        printString(ps, "   private final %s value;", type)
        printString(ps, "    %s( %s value) {", classname, type)
        ps!!.println("        this.value = value;")
        ps.println("    }")
        ps.println()
        printString(ps, "\n   public %s getValue() {" +
                "\n        return  value;" +
                "\n    }", type)
        ps.println()
        ps.println("   @Override\n   public String toString() {")
        if (isIntVal) {
            printString(ps, "        return  String.valueOf(value);")
        } else {
            printString(ps, "        return  value;")
        }
        ps.println("    }")
        ps.println("}")
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
                    childKey = if (item.isModel) {
                        item.key + "_" + key
                    } else {
                        item.key.replace("Response", "") + "_" + key + "Response"
                    }
                    val childItem = addToMissingDefinition(childKey, jsonProp, item.isModel)
                    if (childItem != null) {
                        generateClass(childItem)
                    }
                }
                writeClassProperty(ps, classname, key, jsonProp, required, isFirst, item.isModel)
                isFirst = false
            }
        }
        closeClass(ps)
        ps.close()
    }

    private fun writeClassProperty(ps: PrintStream?, classname: String?, key: String?, jsonAttrs: JSONObject?, required: ArrayList<String?>?, isFirst: Boolean, isModel: Boolean) {
        val type: Type?
        type = if (jsonAttrs!!.has("additionalProperties")) {
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

    private fun addToMissingDefinition(key: String?, json: JSONObject?, isModel: Boolean?): DefItem? {
        if (definitionMap!!.containsKey(key)) {
            return null
        }
        val kind: Int
        kind = if (json!!.has("enum")) {
            KIND_ENUM
        } else {
            KIND_CLASS
        }
        if (DEBUG) {
            println("add def " + key + (if (kind == KIND_ENUM) "/enum" else "/class") + " / " + json.toString())
        }
        val item = DefItem()
        item.key = key
        item.json = json
        item.kind = kind
        item.isModel = isModel!!
        definitionMap[key] = item
        missingDefinition!!.add(key)
        return item
    }

    @Throws(IOException::class)
    private fun prepareDefinition(item: DefItem?) {
        if (item!!.isModel) {
            outputDirFile = File(outputDir + File.separator + modelPackageName!!.replace('.', '/'))
            outputDirFile!!.mkdirs()
        } else {
            outputDirFile = File(outputDir + File.separator + responsePackageName!!.replace('.', '/'))
            outputDirFile!!.mkdirs()
        }
    }

    private fun prepareAction() {
        outputDirFile = File(outputDir)
        outputDirFile!!.mkdirs()
    }

    private fun closeClass(ps: PrintStream?) {
        ps!!.println()
        ps.println(")")
    }

    private fun openClass(ps: PrintStream?, item: DefItem?, classname: String?) {
        printStringS(ps, "%sclass %s (", if (item!!.isModel) "" else "", classname)
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
        if (item!!.isModel) {
        } else {
            ps!!.println("import com.anttek.slack.model.*")
        }
        ps!!.println()
    }

    private fun writeClassPackage(ps: PrintStream?, item: DefItem?) {
        ps!!.print("package ")
        ps.print(if (item!!.isModel) modelPackageName else responsePackageName)
        ps.println()
    }

    private fun makeClassName(action: String?): String? {
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
            action
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
        val encoded: ByteArray = Files.readAllBytes(Paths.get(file.absolutePath))
        return String(encoded, Charsets.UTF_8)
    }

    companion object {
        var TYPE_OBJECT = 0
        private const val TYPE_ARRAY_OBJECT = 1
        private const val KIND_ENUM = 0
        private const val KIND_CLASS = 1
        private const val DEBUG = true
        fun isNumeric(str: String?): Boolean {
            return str!!.matches(Regex("-?\\d+(\\.\\d+)?"))
        }

        @JvmStatic
        fun main(args: Array<String>) {
            SlackCallback().generateWithDefault("slack_events_api_async_v1.json")
        }

    }
}