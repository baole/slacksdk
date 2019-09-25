package com.anttek.slack.api.request

data class ImOpenRequest (
        val return_im: Boolean? = null,
        val user: String? = null,
        val include_locale: Boolean? = null
)
