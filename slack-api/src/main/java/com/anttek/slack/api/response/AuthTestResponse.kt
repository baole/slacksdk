package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class AuthTestResponse (
    var userId: String,
    var team: String,
    var teamId: String,
    var user: String,
    var url: String
): BaseResponse()
