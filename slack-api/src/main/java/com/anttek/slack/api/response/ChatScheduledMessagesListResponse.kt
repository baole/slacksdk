package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ChatScheduledMessagesListResponse (
    var scheduledMessages: ArrayList<Any>
): BaseResponse()
