package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class GroupsCreateRequest (
         token: String? = null,
        val validate: Boolean? = null,
        val name: String? = null
) : GenericRequest(token)
