package com.anttek.tool

import org.json.JSONObject

internal class DefItem {
    var key: String = ""
    lateinit var json: JSONObject
    var kind = 0
    var isRequest = true
}
