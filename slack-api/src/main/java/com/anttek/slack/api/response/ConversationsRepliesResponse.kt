package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean? = null,
    var ok: Boolean
)
