package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class DndTeamInfoResponse (
    var cached: Boolean? = null,
    var users: DndTeamInfoUsersResponse
): BaseResponse()
