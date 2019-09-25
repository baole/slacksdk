package com.anttek.slack.request

data class StarsAddRequest (
        val file_comment: String? = null,
        val timestamp: Double? = null,
        val channel: String? = null,
        val file: String? = null
)
