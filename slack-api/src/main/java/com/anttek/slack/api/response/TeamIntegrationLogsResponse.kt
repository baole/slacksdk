package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class TeamIntegrationLogsResponse (
    var paging: Paging,
    var ok: Boolean,
    var logs: ArrayList<Any>
)
