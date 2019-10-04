package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class RtmConnectResponse (
    var self: RtmConnectSelfResponse,
    var team: RtmConnectTeamResponse,
    var url: String
): GenericResponse()
