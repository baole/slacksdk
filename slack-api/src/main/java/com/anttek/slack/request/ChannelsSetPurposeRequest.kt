package com.anttek.slack.request

data class ChannelsSetPurposeRequest (
        val purpose: String? = null,
        val channel: String? = null
)
