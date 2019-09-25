package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsHistoryResponse (
    var pinCount: Long,
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
