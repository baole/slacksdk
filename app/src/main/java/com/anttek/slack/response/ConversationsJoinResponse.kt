package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsJoinResponse (
    var channel: Conversation,
    var warning: String? = null,
    var responseMetadata: Any? = null,
    var ok: Boolean
)
