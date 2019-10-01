package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ChatScheduleMessageResponse (
    var scheduledMessageId: String,
    var channel: String,
    var message: ChatScheduleMessageMessageResponse,
    var postAt: Long
): BaseResponse()
