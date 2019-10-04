package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ConversationsUnarchiveRequest (
         token: String? = null,
        val channel: String? = null
) : GenericRequest(token)
