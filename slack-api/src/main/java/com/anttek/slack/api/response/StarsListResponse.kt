package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class StarsListResponse (
    var paging: Paging? = null,
    var items: ArrayList<Any>
): GenericResponse()
