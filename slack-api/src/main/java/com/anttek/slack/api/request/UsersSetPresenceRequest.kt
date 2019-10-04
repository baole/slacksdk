package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class UsersSetPresenceRequest (
         token: String? = null,
        val presence: String? = null
) : GenericRequest(token)
