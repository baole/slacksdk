package com.anttek.slack.api.request

data class ConversationsSetTopicRequest (
        val topic: String? = null,
        val channel: String? = null
)
