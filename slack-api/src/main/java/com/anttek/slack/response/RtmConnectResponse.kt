package com.anttek.slack.response
import com.anttek.slack.model.*

class RtmConnectResponse (
    var self: RtmConnectSelfResponse,
    var team: RtmConnectTeamResponse,
    var ok: Boolean,
    var url: String
)
