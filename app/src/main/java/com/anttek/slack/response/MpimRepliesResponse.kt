package com.anttek.slack.response
import com.anttek.slack.model.*

class MpimRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean,
    var ok: Boolean
)
