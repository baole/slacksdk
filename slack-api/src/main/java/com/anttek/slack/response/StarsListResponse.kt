package com.anttek.slack.response
import com.anttek.slack.model.*

class StarsListResponse (
    var paging: Paging? = null,
    var ok: Boolean,
    var items: ArrayList<Any>
)
