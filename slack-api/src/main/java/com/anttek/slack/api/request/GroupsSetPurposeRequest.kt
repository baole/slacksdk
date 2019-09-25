package com.anttek.slack.api.request

data class GroupsSetPurposeRequest (
        val purpose: String? = null,
        val channel: String? = null
)
