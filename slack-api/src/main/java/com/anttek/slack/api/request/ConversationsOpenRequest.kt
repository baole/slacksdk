package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ConversationsOpenRequest (
         token: String? = null,
        val return_im: Boolean? = null,
        val users: String? = null,
        val channel: String? = null
) : GenericRequest(token)
