package com.anttek.slack.response
import com.anttek.slack.model.*

class ChatPostMessageResponse (
    var channel: String,
    var message: Message,
    var ok: Boolean,
    var ts: String
)
