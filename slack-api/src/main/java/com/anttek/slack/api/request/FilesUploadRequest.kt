package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class FilesUploadRequest (
         token: String? = null,
        val channels: String? = null,
        val title: String? = null,
        val initial_comment: String? = null,
        val filetype: String? = null,
        val filename: String? = null,
        val content: String? = null,
        val file: String? = null,
        val thread_ts: Double? = null
) : GenericRequest(token)
