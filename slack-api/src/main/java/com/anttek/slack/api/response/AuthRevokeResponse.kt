package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class AuthRevokeResponse (
    var revoked: Boolean
): GenericResponse()
