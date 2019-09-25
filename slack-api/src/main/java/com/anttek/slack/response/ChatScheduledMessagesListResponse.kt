package com.anttek.slack.response
import com.anttek.slack.model.*

class ChatScheduledMessagesListResponse (
    var scheduledMessages: ArrayList<Any>,
    var responseMetadata: ChatScheduledMessagesListResponseMetadataResponse,
    var ok: Boolean
)
