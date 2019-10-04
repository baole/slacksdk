package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ChannelsJoinResponse (
    var alreadyInChannel: Boolean? = null,
    var channel: Channel
): GenericResponse()
