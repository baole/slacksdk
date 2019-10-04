package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChannelsSetTopicRequest (
         token: String? = null,
        val topic: String? = null,
        val channel: String? = null
) : GenericRequest(token)
