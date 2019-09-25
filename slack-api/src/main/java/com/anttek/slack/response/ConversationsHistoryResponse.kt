package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsHistoryResponse (
    var pinCount: Long,
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
