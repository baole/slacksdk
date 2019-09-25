package com.anttek.slack.api.request

data class ChatUpdateRequest (
        val blocks: String? = null,
        val attachments: String? = null,
        val text: String? = null,
        val ts: Double? = null,
        val parse: String? = null,
        val as_user: Boolean? = null,
        val link_names: Boolean? = null,
        val channel: String? = null
)
