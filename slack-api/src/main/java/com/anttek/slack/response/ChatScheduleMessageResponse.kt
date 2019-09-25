package com.anttek.slack.response
import com.anttek.slack.model.*

class ChatScheduleMessageResponse (
    var scheduledMessageId: String,
    var channel: String,
    var message: ChatScheduleMessageMessageResponse,
    var ok: Boolean,
    var postAt: Long
)
