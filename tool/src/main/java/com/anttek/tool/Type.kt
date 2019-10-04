package com.anttek.tool

import com.anttek.tool.SlackApi.Companion.isNumeric

class Type internal constructor(var type: String, var kind: Int) {
    var targetKind = 0
    var isPrimative = false
    var `in`: String = ""
    var name: String = ""

    val fullType: String
        get() = if (kind == SlackApi.TYPE_OBJECT) {
            type
        } else {
            String.format("ArrayList<%s>", makeClassName(type))
        }

    fun makeClassName(action: String): String {
        return try {
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

}
