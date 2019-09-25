package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class TeamAccessLogsResponse (
    var paging: Paging,
    var ok: Boolean,
    var logins: ArrayList<Any>
)
