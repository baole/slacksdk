package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class GroupsRepliesResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean? = null,
    var ok: Boolean
)
