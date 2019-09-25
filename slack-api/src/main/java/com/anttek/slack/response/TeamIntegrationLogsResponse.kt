package com.anttek.slack.response
import com.anttek.slack.model.*

class TeamIntegrationLogsResponse (
    var paging: Paging,
    var ok: Boolean,
    var logs: ArrayList<Any>
)
