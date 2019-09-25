package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsJoinResponse (
    var channel: Conversation,
    var warning: String? = null,
    var responseMetadata: Any? = null,
    var ok: Boolean
)
