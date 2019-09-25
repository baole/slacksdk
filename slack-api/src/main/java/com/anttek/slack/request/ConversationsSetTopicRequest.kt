package com.anttek.slack.request

data class ConversationsSetTopicRequest (
        val topic: String? = null,
        val channel: String? = null
)
