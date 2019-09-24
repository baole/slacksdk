package com.anttek.tool

object Schema2Java {
    @JvmStatic
    fun main(args: Array<String>) {
        CodeGeneratorV2().generateWithDefault("slack_web_openapi_v2.json")
//        println("Hello")
    }
}
