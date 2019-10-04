package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ChatPostMessageResponse (
    var channel: String,
    var message: Message
): GenericResponse()
