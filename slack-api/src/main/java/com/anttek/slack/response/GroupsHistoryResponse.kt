package com.anttek.slack.response
import com.anttek.slack.model.*

class GroupsHistoryResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
