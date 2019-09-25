package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsListResponse (
    var channels: ArrayList<Conversation>,
    var responseMetadata: ConversationsListResponseMetadataResponse? = null,
    var ok: Boolean
)
