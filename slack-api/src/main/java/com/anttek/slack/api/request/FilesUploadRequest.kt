package com.anttek.slack.api.request

data class FilesUploadRequest (
        val channels: String? = null,
        val title: String? = null,
        val initial_comment: String? = null,
        val filetype: String? = null,
        val filename: String? = null,
        val content: String? = null,
        val file: String? = null,
        val thread_ts: Double? = null
)
