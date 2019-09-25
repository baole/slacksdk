package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ChatScheduledMessagesListResponse (
    var scheduledMessages: ArrayList<Any>,
    var responseMetadata: ChatScheduledMessagesListResponseMetadataResponse,
    var ok: Boolean
)
