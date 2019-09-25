package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class ReactionsListResponse (
    var paging: Paging? = null,
    var responseMetadata: ResponseMetadata? = null,
    var ok: Boolean,
    var items: ArrayList<Any>
)
