package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class MpimRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean,
    var ok: Boolean
)
