package com.anttek.slack.api.request

data class ConversationsCreateRequest (
        val user_ids: String? = null,
        val name: String? = null,
        val is_private: Boolean? = null
)