package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class StarsListResponse (
    var paging: Paging? = null,
    var ok: Boolean,
    var items: ArrayList<Any>
)
