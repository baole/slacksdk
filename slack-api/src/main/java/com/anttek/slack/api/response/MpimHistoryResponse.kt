package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class MpimHistoryResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)