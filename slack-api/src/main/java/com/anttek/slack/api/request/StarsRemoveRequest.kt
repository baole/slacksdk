package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class StarsRemoveRequest (
         token: String? = null,
        val file_comment: String? = null,
        val timestamp: Double? = null,
        val channel: String? = null,
        val file: String? = null
) : GenericRequest(token)
