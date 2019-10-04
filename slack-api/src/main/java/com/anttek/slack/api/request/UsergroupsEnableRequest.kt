package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class UsergroupsEnableRequest (
         token: String? = null,
        val include_count: Boolean? = null,
        val usergroup: String? = null
) : GenericRequest(token)
