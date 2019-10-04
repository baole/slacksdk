package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ConversationsRenameRequest (
         token: String? = null,
        val name: String? = null,
        val channel: String? = null
) : GenericRequest(token)
