package com.anttek.slack.request

data class ChatUnfurlRequest (
        val user_auth_message: String? = null,
        val user_auth_required: Boolean? = null,
        val unfurls: String? = null,
        val ts: String? = null,
        val user_auth_url: String? = null,
        val channel: String? = null
)
