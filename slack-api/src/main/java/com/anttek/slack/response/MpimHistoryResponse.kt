package com.anttek.slack.response
import com.anttek.slack.model.*

class MpimHistoryResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
