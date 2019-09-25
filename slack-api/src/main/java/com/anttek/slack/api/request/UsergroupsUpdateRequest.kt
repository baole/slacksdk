package com.anttek.slack.api.request

data class UsergroupsUpdateRequest (
        val handle: String? = null,
        val description: String? = null,
        val channels: String? = null,
        val include_count: Boolean? = null,
        val usergroup: String? = null,
        val name: String? = null
)
