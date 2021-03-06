package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ChatScheduleMessageMessageResponse (
    var text: String,
    var type: String,
    var user: String,
    var botId: String,
    var username: String? = null
): GenericResponse()
