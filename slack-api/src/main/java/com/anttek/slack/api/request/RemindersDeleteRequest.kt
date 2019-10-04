package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class RemindersDeleteRequest (
         token: String? = null,
        val reminder: String? = null
) : GenericRequest(token)
