package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class GroupsSetPurposeRequest (
         token: String? = null,
        val purpose: String? = null,
        val channel: String? = null
) : GenericRequest(token)
