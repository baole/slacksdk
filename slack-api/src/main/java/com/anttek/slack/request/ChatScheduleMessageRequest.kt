package com.anttek.slack.request

data class ChatScheduleMessageRequest (
        val thread_ts: Double? = null,
        val blocks: String? = null,
        val attachments: String? = null,
        val unfurl_links: Boolean? = null,
        val text: String? = null,
        val link_names: Boolean? = null,
        val unfurl_media: Boolean? = null,
        val parse: String? = null,
        val as_user: Boolean? = null,
        val post_at: String? = null,
        val channel: String? = null,
        val reply_broadcast: Boolean? = null
)
