package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ChatPostMessageResponse (
    var channel: String,
    var message: Message,
    var ok: Boolean,
    var ts: String
)
