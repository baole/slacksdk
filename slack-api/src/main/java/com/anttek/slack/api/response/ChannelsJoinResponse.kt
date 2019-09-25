package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ChannelsJoinResponse (
    var alreadyInChannel: Boolean? = null,
    var channel: Channel,
    var ok: Boolean
)
