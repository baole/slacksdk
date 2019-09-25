package com.anttek.slack.request

data class ConversationsInviteRequest (
        val users: String? = null,
        val channel: String? = null
)
