package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

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
): BaseResponse()
