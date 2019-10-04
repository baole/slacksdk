package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChannelsMarkRequest (
         token: String? = null,
        val ts: Double? = null,
        val channel: String? = null
) : GenericRequest(token)
