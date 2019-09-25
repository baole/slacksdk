package com.anttek.slack.api.request

data class ConversationsSetPurposeRequest (
        val purpose: String? = null,
        val channel: String? = null
)
