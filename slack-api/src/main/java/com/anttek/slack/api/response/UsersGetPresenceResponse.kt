package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class UsersGetPresenceResponse (
    var autoAway: Boolean? = null,
    var manualAway: Boolean? = null,
    var lastActivity: Long? = null,
    var connectionCount: Long? = null,
    var online: Boolean? = null,
    var presence: String
): GenericResponse()
