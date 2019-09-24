package com.anttek.slack.response
import com.anttek.slack.model.*

class ChannelsRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean,
    var ok: Boolean
)
