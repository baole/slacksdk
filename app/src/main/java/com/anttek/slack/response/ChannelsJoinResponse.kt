package com.anttek.slack.response
import com.anttek.slack.model.*

class ChannelsJoinResponse (
    var alreadyInChannel: Boolean? = null,
    var channel: Channel,
    var ok: Boolean
)
