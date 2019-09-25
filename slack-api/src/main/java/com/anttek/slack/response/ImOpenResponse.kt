package com.anttek.slack.response
import com.anttek.slack.model.*

class ImOpenResponse (
    var alreadyOpen: Boolean? = null,
    var channel: ImOpenChannelResponse,
    var ok: Boolean,
    var noOp: Boolean? = null
)
