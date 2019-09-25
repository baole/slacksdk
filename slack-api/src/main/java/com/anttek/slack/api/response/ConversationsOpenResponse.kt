package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsOpenResponse (
    var alreadyOpen: Boolean? = null,
    var channel: Conversation,
    var ok: Boolean,
    var noOp: Boolean? = null
)
