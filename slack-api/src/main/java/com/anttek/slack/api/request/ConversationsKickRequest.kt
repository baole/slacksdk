package com.anttek.slack.api.request

data class ConversationsKickRequest (
        val user: String? = null,
        val channel: String? = null
)
