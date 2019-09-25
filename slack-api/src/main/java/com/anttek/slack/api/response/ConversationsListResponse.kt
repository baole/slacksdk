package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsListResponse (
    var channels: ArrayList<Conversation>,
    var responseMetadata: ConversationsListResponseMetadataResponse? = null,
    var ok: Boolean
)
