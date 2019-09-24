package com.anttek.slack.response
import com.anttek.slack.model.*

class ImOpenChannelResponse (
    var lastRead: String? = null,
    var unreadCount: Double? = null,
    var isIm: Boolean? = null,
    var isOpen: Boolean? = null,
    var created: String? = null,
    var id: String,
    var unreadCountDisplay: Double? = null,
    var user: String? = null,
    var latest: Message? = null
)
