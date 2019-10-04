package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChannelsSetPurposeRequest (
         token: String? = null,
        val purpose: String? = null,
        val channel: String? = null
) : GenericRequest(token)
