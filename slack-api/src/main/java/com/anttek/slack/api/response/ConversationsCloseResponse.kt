package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsCloseResponse (
    var alreadyClosed: Boolean? = null,
    var ok: Boolean,
    var noOp: Boolean? = null
)
