package com.anttek.slack.response
import com.anttek.slack.model.*

class TeamAccessLogsResponse (
    var paging: Paging,
    var ok: Boolean,
    var logins: ArrayList<Any>
)
