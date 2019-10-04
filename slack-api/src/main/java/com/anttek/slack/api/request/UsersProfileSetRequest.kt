package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class UsersProfileSetRequest (
         token: String? = null,
        val profile: String? = null,
        val user: String? = null,
        val value: String? = null,
        val name: String? = null
) : GenericRequest(token)
