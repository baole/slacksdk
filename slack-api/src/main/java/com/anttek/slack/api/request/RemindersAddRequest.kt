package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class RemindersAddRequest (
         token: String? = null,
        val text: String? = null,
        val user: String? = null,
        val time: String? = null
) : GenericRequest(token)
