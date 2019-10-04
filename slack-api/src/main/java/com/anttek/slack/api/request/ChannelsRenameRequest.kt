package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ChannelsRenameRequest (
         token: String? = null,
        val validate: Boolean? = null,
        val name: String? = null,
        val channel: String? = null
) : GenericRequest(token)
