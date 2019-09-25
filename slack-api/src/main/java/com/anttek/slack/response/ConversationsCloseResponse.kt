package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsCloseResponse (
    var alreadyClosed: Boolean? = null,
    var ok: Boolean,
    var noOp: Boolean? = null
)
