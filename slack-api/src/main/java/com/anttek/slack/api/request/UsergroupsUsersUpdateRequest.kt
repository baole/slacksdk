package com.anttek.slack.api.request

data class UsergroupsUsersUpdateRequest (
        val users: String? = null,
        val include_count: Boolean? = null,
        val usergroup: String? = null
)
