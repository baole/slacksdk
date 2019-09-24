package com.anttek.slack.response
import com.anttek.slack.model.*

class ImHistoryResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
