package com.anttek.slack.api.response

import com.anttek.slack.api.GenericResponse
import com.anttek.slack.api.model.User

class UsersListResponse() : GenericResponse() {
    var cacheTs: Long? = null
    var members: ArrayList<User>? = ArrayList()
}
