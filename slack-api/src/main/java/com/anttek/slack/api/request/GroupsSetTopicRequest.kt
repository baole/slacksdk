package com.anttek.slack.api.request

data class GroupsSetTopicRequest (
        val topic: String? = null,
        val channel: String? = null
)