package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class FilesRevokePublicURLRequest (
         token: String? = null,
        val file: String? = null
) : GenericRequest(token)
