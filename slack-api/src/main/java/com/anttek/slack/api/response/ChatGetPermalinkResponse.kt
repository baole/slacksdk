package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ChatGetPermalinkResponse (
    var channel: String,
    var permalink: String
): BaseResponse()
