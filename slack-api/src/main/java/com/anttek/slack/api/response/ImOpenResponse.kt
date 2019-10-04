package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ImOpenResponse (
    var alreadyOpen: Boolean? = null,
    var channel: ImOpenChannelResponse,
    var noOp: Boolean? = null
): GenericResponse()
