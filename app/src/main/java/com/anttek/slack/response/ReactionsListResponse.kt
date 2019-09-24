package com.anttek.slack.response
import com.anttek.slack.model.*

class ReactionsListResponse (
    var paging: Paging? = null,
    var responseMetadata: ResponseMetadata? = null,
    var ok: Boolean,
    var items: ArrayList<Any>
)
