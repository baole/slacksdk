package com.anttek.slack.request

data class ChatPostMessageRequest (
        val attachments: String? = null,
        val unfurl_links: Boolean? = null,
        val text: String? = null,
        val unfurl_media: Boolean? = null,
        val parse: String? = null,
        val as_user: Boolean? = null,
        val mrkdwn: Boolean? = null,
        val channel: String? = null,
        val username: String? = null,
        val blocks: String? = null,
        val icon_emoji: String? = null,
        val link_names: Boolean? = null,
        val reply_broadcast: Boolean? = null,
        val thread_ts: Double? = null,
        val icon_url: String? = null
)
