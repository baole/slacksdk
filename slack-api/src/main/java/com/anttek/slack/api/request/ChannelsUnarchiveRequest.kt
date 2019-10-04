package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChannelsUnarchiveRequest (
         token: String? = null,
        val channel: String? = null
) : GenericRequest(token)
