package com.anttek.slack.response
import com.anttek.slack.model.*

class ChatUpdateResponse (
    var channel: String,
    var text: String,
    var message: ChatUpdateMessageResponse,
    var ok: Boolean,
    var ts: String
)
