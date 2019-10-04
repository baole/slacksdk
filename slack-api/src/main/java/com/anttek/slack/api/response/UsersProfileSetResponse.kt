package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class UsersProfileSetResponse (
    var profile: UserProfile,
    var username: String
): GenericResponse()
