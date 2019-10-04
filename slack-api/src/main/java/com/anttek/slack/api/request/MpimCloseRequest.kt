package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class MpimCloseRequest (
         token: String? = null,
        val channel: String? = null
) : GenericRequest(token)
