package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ImMarkRequest (
         token: String? = null,
        val channel: String? = null,
        val ts: Double? = null
) : GenericRequest(token)
