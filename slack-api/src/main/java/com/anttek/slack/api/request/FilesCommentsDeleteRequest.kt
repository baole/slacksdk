package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class FilesCommentsDeleteRequest (
         token: String? = null,
        val id: String? = null,
        val file: String? = null
) : GenericRequest(token)
