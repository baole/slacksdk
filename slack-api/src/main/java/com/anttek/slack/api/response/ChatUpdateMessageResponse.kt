package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ChatUpdateMessageResponse (
    var team: String? = null,
    var text: String,
    var type: String,
    var user: String
): BaseResponse()
