package com.anttek.slack.api.request

data class StarsRemoveRequest (
        val file_comment: String? = null,
        val timestamp: Double? = null,
        val channel: String? = null,
        val file: String? = null
)
