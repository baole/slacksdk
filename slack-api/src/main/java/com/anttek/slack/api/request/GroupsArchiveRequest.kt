package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class GroupsArchiveRequest (
         token: String? = null,
        val channel: String? = null
) : GenericRequest(token)
