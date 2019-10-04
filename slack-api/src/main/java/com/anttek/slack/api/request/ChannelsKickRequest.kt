package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChannelsKickRequest (
         token: String? = null,
        val user: String? = null,
        val channel: String? = null
) : GenericRequest(token)
