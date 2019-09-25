package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class UsersProfileSetResponse (
    var profile: UserProfile,
    var ok: Boolean,
    var username: String
)
