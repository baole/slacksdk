package com.anttek.slack.api

import com.fasterxml.jackson.databind.ObjectMapper

interface Mapper {
    fun toMap(obj: Any): Map<String, String>
}
