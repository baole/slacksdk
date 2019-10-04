package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class MpimListResponse (
    var groups: ArrayList<Group>
): GenericResponse()
