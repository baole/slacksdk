package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ChatUpdateResponse (
    var channel: String,
    var text: String,
    var message: ChatUpdateMessageResponse,
    var ok: Boolean,
    var ts: String
)
