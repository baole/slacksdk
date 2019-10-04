package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class MpimOpenRequest (
         token: String? = null,
        val users: String? = null
) : GenericRequest(token)
