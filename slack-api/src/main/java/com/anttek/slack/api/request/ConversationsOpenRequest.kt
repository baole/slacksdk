package com.anttek.slack.api.request

data class ConversationsOpenRequest (
        val return_im: Boolean? = null,
        val users: String? = null,
        val channel: String? = null
)
