package com.anttek.slack.response
import com.anttek.slack.model.*

class UsersProfileSetResponse (
    var profile: UserProfile,
    var ok: Boolean,
    var username: String
)
