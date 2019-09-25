package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class UsersConversationsResponse (
    var channels: ArrayList<Conversation>,
    var responseMetadata: UsersConversationsResponseMetadataResponse? = null,
    var ok: Boolean
)
