package com.anttek.slack.api.request

data class ChannelsSetTopicRequest (
        val topic: String? = null,
        val channel: String? = null
)
