package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class FilesSharedPublicURLRequest (
         token: String? = null,
        val file: String? = null
) : GenericRequest(token)
