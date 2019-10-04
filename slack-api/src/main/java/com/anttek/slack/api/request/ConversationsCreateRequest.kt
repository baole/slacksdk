package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ConversationsCreateRequest (
         token: String? = null,
        val user_ids: String? = null,
        val name: String? = null,
        val is_private: Boolean? = null
) : GenericRequest(token)
