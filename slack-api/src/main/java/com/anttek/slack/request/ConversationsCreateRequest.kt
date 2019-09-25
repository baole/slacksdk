package com.anttek.slack.request

data class ConversationsCreateRequest (
        val user_ids: String? = null,
        val name: String? = null,
        val is_private: Boolean? = null
)
