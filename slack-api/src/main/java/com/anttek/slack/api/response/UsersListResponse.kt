package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class UsersListResponse (
    var cacheTs: Long,
    var members: ArrayList<User>,
    var responseMetadata: ResponseMetadata? = null,
    var ok: Boolean
)
