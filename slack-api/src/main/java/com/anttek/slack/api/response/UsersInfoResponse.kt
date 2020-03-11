package com.anttek.slack.api.response

import com.anttek.slack.api.GenericResponse
import com.anttek.slack.api.model.User

class UsersInfoResponse() : GenericResponse() {
    var user: User? = null
}
