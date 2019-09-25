package com.anttek.slack.response
import com.anttek.slack.model.*

class UsersListResponse (
    var cacheTs: Long,
    var members: ArrayList<User>,
    var responseMetadata: ResponseMetadata? = null,
    var ok: Boolean
)
