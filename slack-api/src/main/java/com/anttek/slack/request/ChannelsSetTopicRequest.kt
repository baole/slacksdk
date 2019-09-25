package com.anttek.slack.request

data class ChannelsSetTopicRequest (
        val topic: String? = null,
        val channel: String? = null
)
