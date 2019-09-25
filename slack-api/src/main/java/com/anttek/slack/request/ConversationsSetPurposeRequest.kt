package com.anttek.slack.request

data class ConversationsSetPurposeRequest (
        val purpose: String? = null,
        val channel: String? = null
)
