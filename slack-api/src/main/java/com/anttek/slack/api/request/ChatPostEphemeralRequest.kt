package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChatPostEphemeralRequest (
         token: String? = null,
        val thread_ts: Double? = null,
        val blocks: String? = null,
        val attachments: String? = null,
        val as_user: Boolean? = null,
        val parse: String? = null,
        val text: String? = null,
        val user: String? = null,
        val link_names: Boolean? = null,
        val channel: String? = null
) : GenericRequest(token)
