package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class RtmConnectTeamResponse (
    var domain: String,
    var name: String,
    var id: String
): GenericResponse()
