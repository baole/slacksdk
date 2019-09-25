package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class DndTeamInfoResponse (
    var cached: Boolean? = null,
    var ok: Boolean,
    var users: DndTeamInfoUsersResponse
)
