package com.anttek.slack.api.request

data class ChannelsKickRequest (
        val user: String? = null,
        val channel: String? = null
)
