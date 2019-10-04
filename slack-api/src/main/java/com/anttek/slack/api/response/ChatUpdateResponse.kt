package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ChatUpdateResponse (
    var channel: String,
    var text: String,
    var message: ChatUpdateMessageResponse
): GenericResponse()
