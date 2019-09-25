package com.anttek.slack.response
import com.anttek.slack.model.*

class ChatScheduleMessageMessageResponse (
    var text: String,
    var type: String,
    var user: String,
    var botId: String,
    var username: String? = null
)
