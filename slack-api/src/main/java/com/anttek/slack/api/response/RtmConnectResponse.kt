package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class RtmConnectResponse (
    var self: RtmConnectSelfResponse,
    var team: RtmConnectTeamResponse,
    var ok: Boolean,
    var url: String
)
