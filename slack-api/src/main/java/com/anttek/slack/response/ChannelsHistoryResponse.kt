package com.anttek.slack.response
import com.anttek.slack.model.*

class ChannelsHistoryResponse (
    var isLimited: Boolean? = null,
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
