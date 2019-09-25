package com.anttek.slack.api.request

data class ChannelsSetPurposeRequest (
        val purpose: String? = null,
        val channel: String? = null
)
