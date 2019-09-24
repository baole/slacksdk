package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean? = null,
    var ok: Boolean
)
