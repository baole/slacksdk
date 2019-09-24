package com.anttek.slack.response
import com.anttek.slack.model.*

class ConversationsMembersResponse (
    var members: ArrayList<String>,
    var responseMetadata: ConversationsMembersResponseMetadataResponse,
    var ok: Boolean
)
