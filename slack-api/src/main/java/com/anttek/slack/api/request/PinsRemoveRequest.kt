package com.anttek.slack.api.request

data class PinsRemoveRequest (
        val file_comment: String? = null,
        val timestamp: Double? = null,
        val file: String? = null,
        val channel: String? = null
)
