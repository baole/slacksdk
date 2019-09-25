/*
 * Copyright (c) 2016, 2017, 2018, 2019. Tandem. All rights reserved.
 *
 */

package com.anttek.tool;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;

/**
 *
 */
public class CodeGeneratorV2 {

    public static int TYPE_OBJECT = 0;
    private static int TYPE_ARRAY_OBJECT = 1;
    private static int KIND_ENUM = 0;
    private static int KIND_CLASS = 1;

    private String jsonSchemaFile;
    private String modelPackageName, responsePackageName;
    private String outputDir;
    private File outputDirFile;

    private void setJsonSchemaFile(String jsonSchemaFile) {
        this.jsonSchemaFile = jsonSchemaFile;
    }

    private void setPackageName(String packageName) {
        this.modelPackageName = packageName + ".model";
        this.responsePackageName = packageName + ".response";
        this.packageName = packageName;
    }

    private void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    private HashMap<String, DefItem> definitionMap = new HashMap<String, DefItem>();
    private ArrayList<String> missingDefinition = new ArrayList<String>();
    private ArrayList<String> intEnumClaszz = new ArrayList<>();

    private static final boolean DEBUG = true;
    private String packageName;

    public void generateWithDefault(String schemaPath) throws IOException {
        setJsonSchemaFile(schemaPath);
        setOutputDir("slack-api/src/main/java");
        String packagePrefix = "com.anttek.slack";
        setPackageName(packagePrefix);

        File src = new File(outputDir, packagePrefix.replace(".", "/"));
        FileUtils.deleteDirectory(new File(src, "model"));
        FileUtils.deleteDirectory(new File(src, "response"));
        FileUtils.deleteDirectory(new File(src, "request"));


        JSONObject jsonObject = new JSONObject(readFile(jsonSchemaFile));
        generateDefinitions(jsonObject);
        generateApis(jsonObject);
    }

    private void generateApis(JSONObject jsonObject) throws IOException {
        prepareAction();
        JSONObject jsonPaths = jsonObject.getJSONObject("paths");

        File outdir = new File(outputDirFile, packageName.replace(".", "/"));
        outdir.mkdirs();
        PrintStream ps = new PrintStream(new FileOutputStream(new File(outdir, "SlackService.kt")));
        writeActionClassPackage(ps);
        writeActionClassImport(ps);
        printString(ps, "interface SlackService {");


        PrintStream psa = new PrintStream(new FileOutputStream(new File(outdir, "SlackApi.kt")));
        writeActionClassPackage(psa);
        printString(psa, "import com.anttek.slack.request.*");
        printString(psa, "import com.anttek.slack.response.*");
        printString(psa);
        printString(psa, "class SlackApi(private val service: SlackService, private val mapper: Mapper, private var token: String = \"\") : BaseSlackApi() {");
        printString(psa, "    fun token(token: String): SlackApi {");
        printString(psa,"         this.token = token");
        printString(psa, "        return this");
        printString(psa, "    }");
        printString(psa);
        printString(psa, "    private fun authen() = \"Bearer $token\"");
        printString(psa);

        for (String key : jsonPaths.keySet()) {
            generateMethod(ps, psa, key, jsonPaths.getJSONObject(key));
        }

        printString(ps, "}");
        printString(psa, "}");
    }

    private void generateMethod(PrintStream ps, PrintStream psa, String key, JSONObject json) throws IOException {
        if (json.has("get")) {
            generateMethod(ps, psa, key, json.getJSONObject("get"), true);
        }
        if (json.has("post")) {
            generateMethod(ps, psa, key, json.getJSONObject("post"), false);
        }
    }

    private void generateMethod(PrintStream ps, PrintStream psa, String key, JSONObject json, boolean isGet) throws IOException{
        String title = json.getString("operationId");
        String classname = makeClassName(title + "Response");

        JSONArray jsonParams = json.getJSONArray("parameters");

        printString(ps, "    @%s(\"%s\")", getHttpMethod(isGet), key.substring(1));
        printStringS(ps, "    fun %s(", makeFieldName(title));
        String name = makeClassName(key.substring(1).replace(".", "_")) + "Request";

        printStringS(psa, "    fun %s(", makeFieldName(title));

        if (isGet) {
//            printStringS(ps, "@QueryMap request: %s", name);
        } else {
            printStringS(ps, "@Header(\"Authorization\") authorization: String, @Body request: %s", name);
            printString(ps, "): Call<%s>", classname);
            printString(ps, "");

            printString(psa, "request: %s): SlackResponse<%s> {", makeClassName(title) + "Request", makeClassName(title) + "Response" );
        }


        int paramCount = jsonParams.length();
        ArrayList<RetrofitParam> params = new ArrayList<>();
        for (int i = 0; i < paramCount; i++) {
            Type type = resolveType(jsonParams.getJSONObject(i));
            if (type.in.equals("query") || type.in.equals("formData")) {
                params.add(new RetrofitParam(type.name, type.getType(), "Query"));
            } else if (type.in.equals("header")) {
                params.add(new RetrofitParam(type.name, type.getType(), "Header"));
            } else {
                System.err.println("Warning: resolveType: retrofit param " + type.in);
            }
        }

        boolean hasToken = false;
        ArrayList<RetrofitParam> pr = new ArrayList<>();
        for (RetrofitParam param : params) {
            if (param.getAnnoType().equals("Header") || param.getTypeName().equals("token")) {
                if (isGet) {
                    pr.add(param);
                }
                hasToken = true;
            }
        }

        for (RetrofitParam param : params) {
            if (!"token".equals(param.getTypeName())  && !"cursor".equals(param.getTypeName()) && !"limit".equals(param.getTypeName())) {
                param.setNull(true);
                pr.add(param);
            }
        }

        for (RetrofitParam param : params) {
            if ("cursor".equals(param.getTypeName()) || "limit".equals(param.getTypeName())) {
                param.setNull(true);
                pr.add(param);
            }
        }
        if (isGet) {
            boolean isFirst = true, isApiFirst = true;
            StringBuilder paramsList = new StringBuilder();
            for (RetrofitParam param : pr) {
                if (!isFirst) {
                    printString(ps, ",");
                    printStringS(ps, "                                ");

                }

                if (!isApiFirst) {
                    printString(psa, ",");
                    printStringS(psa, "                                ");
                }

                printStringS(ps, "@Query(\"%s\") %s: %s%s",
//                    param.getAnnoType(),
                        param.getTypeName(), makeFieldName(param.getTypeName()), param.getReturnType(), param.isNull() ? "? = null": "");
                if (!"token".equals(param.getTypeName())) {
                    printStringS(psa, "%s: %s%s", makeFieldName(param.getTypeName()), param.getReturnType(), param.isNull() ? "? = null": "");
                    if (!isApiFirst || hasToken) {
                        paramsList.append(", ");
                    }
                    paramsList.append(makeFieldName(param.getTypeName()));
                    isApiFirst = false;
                }

                isFirst = false;
            }
            printString(ps, "): Call<%s>", classname);
            printString(ps, "");

            printString(psa, "): SlackResponse<%s> {", classname);
            printString(psa, "        return getResponse(service.%s(%s%s))", makeFieldName(title), hasToken ? "token": "", paramsList.toString());
            printString(psa, "    }");
        } else {
            generateActionRequestClass(key, json, isGet, pr);

            printString(psa, "        return getResponse(service.%s(authen(), request))", makeFieldName(title));
            printString(psa, "    }");
        }
        printString(psa);
    }

    private void generateActionRequestClass(String key, JSONObject json, boolean isGet, ArrayList<RetrofitParam> params) throws IOException {
        String classname = makeClassName(key.substring(1).replace(".", "_")) + "Request";
        File outdir = new File(outputDirFile, packageName.replace(".", "/") + "/request");
        outdir.mkdirs();
        PrintStream ps = new PrintStream(new FileOutputStream(new File(outdir, classname + ".kt")));

        printString(ps, "package com.anttek.slack.request");
        printString(ps, "");
        printStringS(ps, "%sclass %s (", params.size() > 0 ? "data " : "", classname);

        boolean isFirst = true;
        for (RetrofitParam param : params) {
            printString(ps, isFirst ? "" : ",");
            printStringS(ps, "        ");
            printStringS(ps, "val %s: %s%s", param.getTypeName(), param.getReturnType(), param.isNull() ? "? = null": "");
            isFirst = false;
        }

        printString(ps, "");
        printString(ps, ")");
        ps.close();
    }

    private String getHttpMethod(boolean isGet) {
        return isGet ? "GET" : "POST";
    }

    private String getMethodPrefix(boolean isGet) {
        return isGet ? "get" : "post";
    }

    private void writeActionClassPackage(PrintStream ps) {
        ps.print("package ");
        ps.print(packageName);
        ps.println();
    }


    private Type resolveType(JSONObject json) {
        return resolveType(json, true);
    }

    private Type resolveType(JSONObject json, boolean recursive) {
        String dataType = "Any";
        int kind = TYPE_OBJECT;
        int targetKind = KIND_CLASS;
        boolean isPrimitive = false;
        String typeStr = null;

        if (json.has("$ref")) {
            dataType = json.getString("$ref");
            dataType = dataType.replace("#/definitions/", "");
            if (dataType.startsWith("defs_")) {
                typeStr = defTypeMap.get(dataType);
            }
        } else if (json.has("type")) {
            try {
                typeStr = json.getString("type");
            } catch (Throwable e) {
                System.err.println(json.toString(4));
                return null;

            }
        }

        if (typeStr != null) {
            if ("string".equals(typeStr)) {
                dataType = "String";
                isPrimitive = true;
            } else if ("boolean".equals(typeStr) || "Boolean".equals(typeStr)) {
                dataType = "Boolean";
                isPrimitive = true;
            } else if ("integer".equals(typeStr)) {
                dataType = "Long";
                isPrimitive = true;
            } else if ("number".equals(typeStr)) {
                dataType = "Double";
                isPrimitive = true;
            } else if ("object".equals(typeStr)) {
                dataType = "Any";
                System.err.println("Warning: resolveType: too generic Object/" + json.toString());
            } else if ("array".equals(typeStr)) {
                kind = TYPE_ARRAY_OBJECT;
                if (recursive) {
                    if (json.has("items")) {
                        JSONObject jsonItems = json.getJSONObject("items");
                        dataType = resolveType(jsonItems, false).getFullType();
                    } else {
                        dataType = "Any";
                    }
                } else {
                    System.err.println("Warning: resolveType: unknow type: " + typeStr + "/" + json.toString());
                    return null;
                }
            } else {
                System.err.println("Warning: resolveType: unknow type: " + typeStr + "/" + json.toString());
            }
        } else if (json.has("$ref")) {
            dataType = json.getString("$ref");
            dataType = dataType.replace("#/definitions/", "");
            String className = makeClassName(dataType);

            if (definitionMap.containsKey(dataType) && definitionMap.get(dataType).kind == KIND_ENUM) {
                targetKind = KIND_ENUM;
            }
        } else {
            System.err.println("Warning: resolveType: unknow type: " + json.toString());
        }

        Type type = new Type(makeClassName(dataType), kind);
        type.targetKind = targetKind;
        type.isPrimative = isPrimitive;

        if (json.has("in")) type.in = json.getString("in");
        if (json.has("name")) type.name = json.getString("name");

        return type;

    }

    private void writeActionClassImport(PrintStream ps) {
        ps.println("import " + packageName + ".model.*");
        ps.println("import com.anttek.slack.request.*");
        ps.println("import com.anttek.slack.response.*");
        ps.println("import retrofit2.Call");
        ps.println("import retrofit2.http.Header");
        ps.println("import retrofit2.http.GET");
        ps.println("import retrofit2.http.POST");
        ps.println("import retrofit2.http.Query");
        ps.println("import retrofit2.http.Body");
        ps.println("import retrofit2.http.QueryMap");

        ps.println();
    }

    ///------------- definitions ------------
    Map<String, String> defTypeMap = new HashMap<>();

    private void generateDefinitions(JSONObject jsonObject) throws IOException {
        JSONObject jsonDefinitions = jsonObject.getJSONObject("definitions");

        for (String key : jsonDefinitions.keySet()) {
            JSONObject jsonDefinition = jsonDefinitions.getJSONObject(key);
            if (key.startsWith("defs_")) {
                defTypeMap.put(key, jsonDefinition.getString("type"));
            } else {
                addToMissingDefinition(key, jsonDefinition, true);
                generateClass(definitionMap.get(key));
            }
        }

        JSONObject jsonPaths = jsonObject.getJSONObject("paths");
        for (String key : jsonPaths.keySet()) {
            JSONObject jsonPath = jsonPaths.getJSONObject(key);
            if (jsonPath.has("get")) {
                generateResponseObject(key, jsonPath.getJSONObject("get"), true);
            }
            if (jsonPath.has("post")) {
                generateResponseObject(key, jsonPath.getJSONObject("post"), false);
            }
        }

        ArrayList<String> keys = new ArrayList<String>(definitionMap.keySet());

        do {
            for (String key : keys) {
                if (DEBUG) {
                    System.out.println(key + " / " + definitionMap.get(key).kind);
                }
                DefItem item = definitionMap.get(key);
                if (item.kind == KIND_ENUM) {
                    generateEnum(item);
                } else {
                    generateClass(item);
                }
            }

            keys = new ArrayList<String>(missingDefinition);
            missingDefinition.clear();
        } while (keys.size() > 0);
    }

    private void generateResponseObject(String key, JSONObject json, boolean isGet) throws IOException {
        JSONObject jsonSchema = json.getJSONObject("responses").getJSONObject("200").getJSONObject("schema");
        String newKey = json.getString("operationId") + "_" + "Response";
        addToMissingDefinition(newKey, jsonSchema, false);
        generateClass(definitionMap.get(newKey));
    }

    private void generateEnum(DefItem item) throws FileNotFoundException {
        String classname = makeClassName(item.key);
        boolean isIntVal = "integer".equals(item.json.getString("type"));
        String type = isIntVal ? "int" : "String";

        PrintStream ps = new PrintStream(new FileOutputStream(new File(outputDirFile, classname + ".kt")));

        writeClassPackage(ps, item);
        writeClassImport(ps, item);
        writeClassDescription(ps, item);

        if (isIntVal) {
            if (!intEnumClaszz.contains(classname)) {
                intEnumClaszz.add(classname);
            }
        }

        openEnum(ps, classname, isIntVal);

        JSONArray enums = item.json.getJSONArray("enum");


        boolean first = true;
        int length = enums.length();

        StringBuilder creator = new StringBuilder();

        try {

            for (int i = 0; i < length; i++) {
                if (first) {
                    first = false;
                } else {
                    ps.println(",");
                }

                String name = null;

                try {
                    name = enums.getString(i);
                } catch (Throwable e) {
                    //ignored
                }

                if (name == null) {
                    try {
                        name = String.valueOf(enums.getInt(i));
                    } catch (Throwable e) {
                        //ignored
                        System.err.println(enums.toString(4));

                    }
                }

                String upperName = makeClassName(name.toUpperCase());
                upperName = makeEnumField(upperName);

                ps.print("      @SerializedName(\"");
                ps.print(name);
                ps.print("\")");
                if (isIntVal) {
                    ps.print(upperName + "(" + name + ")");
                } else {
                    ps.print(upperName + "(\"" + name + "\")");
                }

                if (isIntVal) {
                    creator.append("    if(").append(upperName).append(".value == value){").append("\n")
                            .append("       return ").append(upperName).append(";").append("\n")
                            .append("       }").append("\n");
                } else {
                    creator.append("    if(").append(upperName).append(".value.equals(value)){").append("\n")
                            .append("       return ").append(upperName).append(";").append("\n")
                            .append("       }").append("\n");
                }

            }
        } catch (Throwable e) {
            System.err.println(enums.toString(4));
            ps.println("//ERROR ");
//            throw new RuntimeException(e);
        }
        ps.println(";");

        printString(ps, "public static %s create(%s value) {%s \n         return null;}",
                makeClassName(classname), type, creator.toString());

        closeEnum(ps, classname, isIntVal);
        ps.close();
    }

    private String makeEnumField(String name) {
        name = name.replace("-", "_");
        return name;
    }

    private void openEnum(PrintStream ps, String classname, boolean isIntVal) {
        printString(ps, "public enum %s %s{", classname, isIntVal ? "implements IntEnum" : "");
    }

    private void closeEnum(PrintStream ps, String classname, boolean isIntVal) {
        String type = isIntVal ? "int" : "String";
        printString(ps, "   private final %s value;", type);
        printString(ps, "    %s( %s value) {", classname, type);
        ps.println("        this.value = value;");
        ps.println("    }");

        ps.println();
        printString(ps, "\n   public %s getValue() {" +
                "\n        return  value;" +
                "\n    }", type);

        ps.println();
        ps.println("   @Override\n   public String toString() {");
        if (isIntVal) {
            printString(ps, "        return  String.valueOf(value);");
        } else {
            printString(ps, "        return  value;");
        }
        ps.println("    }");
        ps.println("}");
    }

    private void generateClass(DefItem item) throws IOException {
        if (item == null) {
            return;
        }
        System.out.println("Generate class: " + item.key);

        prepareDefinition(item);

        final String classname = makeClassName(item.key);
        PrintStream ps = new PrintStream(new FileOutputStream(new File(outputDirFile, classname + ".kt")));
        writeClassPackage(ps, item);
        writeClassImport(ps, item);
        writeClassDescription(ps, item);
        openClass(ps, item, classname);

        ArrayList<String> required = new ArrayList<>();
        if (item.json.has("required")) {
            JSONArray jsonArray = item.json.getJSONArray("required");
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                required.add(jsonArray.getString(i));
            }
        }

        if (item.json.has("properties")) {
            JSONObject jsonProperties = item.json.getJSONObject("properties");
            boolean isFirst = true;
            for (String key : jsonProperties.keySet()) {
                JSONObject jsonProp = jsonProperties.getJSONObject(key);
                if (jsonProp.has("additionalProperties")) {
                    String childKey;
                    if (item.isModel) {
                        childKey = item.key + "_" + key;
                    } else {
                        childKey = item.key.replace("Response", "") + "_" + key + "Response";
                    }
                    DefItem childItem = addToMissingDefinition(childKey, jsonProp, item.isModel);
                    if (childItem != null) {
                        generateClass(childItem);
                    }
                }

                writeClassProperty(ps, classname, key, jsonProp, required, isFirst, item.isModel);
                isFirst = false;
            }
        }

        closeClass(ps);
        ps.close();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private void writeClassProperty(PrintStream ps, String classname, String key, JSONObject jsonAttrs, ArrayList<String> required, boolean isFirst, boolean isModel) {
        Type type;
        if (jsonAttrs.has("additionalProperties")) {
            if (isModel) {
                type = new Type(classname + makeClassName(key), CodeGeneratorV2.TYPE_OBJECT);
            } else {
                type = new Type(classname.replace("Response", "") + makeClassName(key) + "Response", CodeGeneratorV2.TYPE_OBJECT);
            }

        } else {
            type = resolveType(jsonAttrs);
        }
        if (type == null) return;

        String fieldType = makeClassName(type.getFullType());

        String desc = jsonAttrs.has("description") ? jsonAttrs.getString("description") : null;
        boolean isRequired = required.contains(key);

        if (desc != null) {
            boolean deprecated = (desc.contains("DEPRECATED") || desc.contains("deprecated"));
            if (deprecated) {
                printString(ps, "   /** @deprecated %s */", desc);
                printString(ps, "   @Deprecated");
            } else {
                printString(ps, "   /** %s */", desc);
            }
        }

        String fieldName = makeFieldName(key);
        printString(ps, isFirst ? "" : ",");
        printStringS(ps, "    var %s: %s%s", fieldName, fieldType, isRequired ? "" : "? = null");
    }

    private DefItem addToMissingDefinition(String key, JSONObject json, Boolean isModel) {
        if (definitionMap.containsKey(key)) {
            return null;
        }

        int kind;
        if (json.has("enum")) {
            kind = KIND_ENUM;
        } else {
            kind = KIND_CLASS;
        }

        if (DEBUG) {
            System.out.println("add def " + key + (kind == KIND_ENUM ? "/enum" : "/class") + " / " + json.toString());
        }


        DefItem item = new DefItem();
        item.key = key;
        item.json = json;
        item.kind = kind;
        item.isModel = isModel;
        definitionMap.put(key, item);
        missingDefinition.add(key);

        return item;
    }

    private void prepareDefinition(DefItem item) throws IOException {
        if (item.isModel) {
            outputDirFile = new File(outputDir + File.separator + modelPackageName.replace('.', '/'));
            outputDirFile.mkdirs();
        } else {
            outputDirFile = new File(outputDir + File.separator + responsePackageName.replace('.', '/'));
            outputDirFile.mkdirs();

        }
    }

    private void prepareAction() {
        outputDirFile = new File(outputDir);
        outputDirFile.mkdirs();

    }

    private void closeClass(PrintStream ps) {
        ps.println();
        ps.println(")");
    }

    private void openClass(PrintStream ps, DefItem item, String classname) {
        printStringS(ps, "%sclass %s (", item.isModel ? "" : "", classname);
    }

    private void printString(PrintStream ps, String string, String... args) {
        ps.println(String.format(string, args));
    }

    private void printString(PrintStream ps) {
        ps.println();
    }

    private void printStringS(PrintStream ps, String string, String... args) {
        ps.print(String.format(string, args));
    }

    private void writeClassDescription(PrintStream ps, DefItem item) {

        String deprecated_ = item.json.has("_deprecated") ? item.json.getString("_deprecated") : null;
        String description = item.json.has("description") ? item.json.getString("description") : null;
        boolean isDeprecated = deprecated_ != null || (description != null && (
                description.contains("DEPRECATED") ||
                        description.contains("deprecated")
        ));

        if (isDeprecated) {
            ps.println("@Deprecated");
        }
    }

    private void writeClassImport(PrintStream ps, DefItem item) {
        if (item.isModel) {

        } else {
            ps.println("import com.anttek.slack.model.*");
        }
        ps.println();
    }

    private void writeClassPackage(PrintStream ps, DefItem item) {
        ps.print("package ");
        ps.print(item.isModel ? modelPackageName : responsePackageName);
        ps.println();
    }

    private String makeClassName(String action) {
        try {
            if (action.startsWith("#/definitions/")) {
                action = action.substring(14);
            }

            if (action.startsWith("objs_")) {
                action = action.substring(5);
            }

            String name = action.substring(0, 1).toUpperCase() + action.substring(1, action.length());

            int _index = name.indexOf("_");
            while (_index >= 0) {
                name = name.substring(0, _index) + name.substring(_index + 1, _index + 2).toUpperCase() + name.substring(_index + 2, name.length());
                _index = name.indexOf("_");
            }

            if (isNumeric(name)) {
                name = "_" + name;
            }

            return name;
        } catch (Throwable e) {
            System.err.println("Error: Cannot formalize classname for " + action);
            return action;
        }
    }

    private String makeFieldName(String input) {
        String name = makeClassName(input);
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    private String readFile(String path) throws IOException {

        File file = new File(getClass().getClassLoader().getResource(path).getFile());
        System.out.println(file.getAbsolutePath());
        byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        return new String(encoded, "UTF-8");
    }

}
