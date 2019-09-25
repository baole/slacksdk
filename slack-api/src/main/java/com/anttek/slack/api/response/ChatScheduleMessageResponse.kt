package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ChatScheduleMessageResponse (
    var scheduledMessageId: String,
    var channel: String,
    var message: ChatScheduleMessageMessageResponse,
    var ok: Boolean,
    var postAt: Long
)
