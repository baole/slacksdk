package com.anttek.slack.api.request

data class RemindersAddRequest (
        val text: String? = null,
        val user: String? = null,
        val time: String? = null
)