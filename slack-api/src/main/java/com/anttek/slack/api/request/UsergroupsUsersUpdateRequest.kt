package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class UsergroupsUsersUpdateRequest (
         token: String? = null,
        val users: String? = null,
        val include_count: Boolean? = null,
        val usergroup: String? = null
) : GenericRequest(token)
