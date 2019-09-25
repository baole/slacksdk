package com.anttek.slack.request

data class ChannelsRenameRequest (
        val validate: Boolean? = null,
        val name: String? = null,
        val channel: String? = null
)
