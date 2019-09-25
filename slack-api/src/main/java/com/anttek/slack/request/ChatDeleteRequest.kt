package com.anttek.slack.request

data class ChatDeleteRequest (
        val as_user: Boolean? = null,
        val ts: Double? = null,
        val channel: String? = null
)
