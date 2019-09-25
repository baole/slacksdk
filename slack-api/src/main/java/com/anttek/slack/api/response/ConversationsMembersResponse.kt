package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ConversationsMembersResponse (
    var members: ArrayList<String>,
    var responseMetadata: ConversationsMembersResponseMetadataResponse,
    var ok: Boolean
)
