package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChatDeleteRequest (
         token: String? = null,
        val as_user: Boolean? = null,
        val ts: Double? = null,
        val channel: String? = null
) : GenericRequest(token)
