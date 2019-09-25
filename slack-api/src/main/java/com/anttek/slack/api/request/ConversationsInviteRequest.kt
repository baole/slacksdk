package com.anttek.slack.api.request

data class ConversationsInviteRequest (
        val users: String? = null,
        val channel: String? = null
)
