package com.anttek.slack.response
import com.anttek.slack.model.*

class GroupsRepliesResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean? = null,
    var ok: Boolean
)
