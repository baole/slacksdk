package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsOpenResponse (
    var alreadyOpen: Boolean? = null,
    var channel: Conversation,
    var ok: Boolean,
    var noOp: Boolean? = null
)
