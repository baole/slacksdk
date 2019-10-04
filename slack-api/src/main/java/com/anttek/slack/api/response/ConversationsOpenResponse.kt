package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ConversationsOpenResponse (
    var alreadyOpen: Boolean? = null,
    var channel: Conversation,
    var noOp: Boolean? = null
): GenericResponse()
