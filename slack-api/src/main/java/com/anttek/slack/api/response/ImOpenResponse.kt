package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ImOpenResponse (
    var alreadyOpen: Boolean? = null,
    var channel: ImOpenChannelResponse,
    var ok: Boolean,
    var noOp: Boolean? = null
)
