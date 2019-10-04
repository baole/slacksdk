package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class ImOpenRequest (
         token: String? = null,
        val return_im: Boolean? = null,
        val user: String? = null,
        val include_locale: Boolean? = null
) : GenericRequest(token)
