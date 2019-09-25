package com.anttek.slack.response
import com.anttek.slack.model.*

class ChatUpdateMessageResponse (
    var team: String? = null,
    var text: String,
    var type: String,
    var user: String
)
