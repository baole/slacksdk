package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ChannelsHistoryResponse (
    var isLimited: Boolean? = null,
    var messages: ArrayList<Message>,
    var hasMore: Boolean,
    var ok: Boolean
)
