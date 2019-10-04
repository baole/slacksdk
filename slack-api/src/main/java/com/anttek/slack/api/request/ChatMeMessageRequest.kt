package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChatMeMessageRequest (
         token: String? = null,
        val text: String? = null,
        val channel: String? = null
) : GenericRequest(token)
