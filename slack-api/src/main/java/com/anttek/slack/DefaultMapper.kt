package com.anttek.slack

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

class DefaultMapper : Mapper {
    private val mapperType: TypeReference<Map<String, String>>
    val mapper: ObjectMapper = ObjectMapper()

    override fun toMap(obj: Any): Map<String, String> {
        return mapper.convertValue(obj, mapperType)
    }

    init {
        mapper.setSerializationInclusion(Include.NON_NULL)
        mapperType = object : TypeReference<Map<String, String>>() {}
    }
}
