package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class UsergroupsUpdateRequest (
         token: String? = null,
        val handle: String? = null,
        val description: String? = null,
        val channels: String? = null,
        val include_count: Boolean? = null,
        val usergroup: String? = null,
        val name: String? = null
) : GenericRequest(token)
