package com.anttek.slack.api

interface Mapper {
    fun toMap(obj: Any): Map<String, String>
}
