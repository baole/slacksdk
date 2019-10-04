package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class PinsRemoveRequest (
         token: String? = null,
        val file_comment: String? = null,
        val timestamp: Double? = null,
        val file: String? = null,
        val channel: String? = null
) : GenericRequest(token)
