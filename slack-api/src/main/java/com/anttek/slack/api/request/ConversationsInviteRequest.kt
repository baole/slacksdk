package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ConversationsInviteRequest (
         token: String? = null,
        val users: String? = null,
        val channel: String? = null
) : GenericRequest(token)
