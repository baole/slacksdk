package com.anttek.slack.response
import com.anttek.slack.model.*

class DndTeamInfoResponse (
    var cached: Boolean? = null,
    var ok: Boolean,
    var users: DndTeamInfoUsersResponse
)
