package com.anttek.slack.response
import com.anttek.slack.model.*

class UsersConversationsResponse (
    var channels: ArrayList<Conversation>,
    var responseMetadata: UsersConversationsResponseMetadataResponse? = null,
    var ok: Boolean
)
