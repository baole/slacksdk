package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class UsersListResponse (
    var cacheTs: Long,
    var members: ArrayList<User>
): GenericResponse()
