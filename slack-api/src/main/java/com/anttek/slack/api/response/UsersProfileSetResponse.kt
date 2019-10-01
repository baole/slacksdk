package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class UsersProfileSetResponse (
    var profile: UserProfile,
    var username: String
): BaseResponse()
