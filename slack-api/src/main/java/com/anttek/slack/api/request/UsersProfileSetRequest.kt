package com.anttek.slack.api.request

data class UsersProfileSetRequest (
        val profile: String? = null,
        val user: String? = null,
        val value: String? = null,
        val name: String? = null
)