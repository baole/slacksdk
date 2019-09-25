package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class UsersGetPresenceResponse (
    var autoAway: Boolean? = null,
    var manualAway: Boolean? = null,
    var lastActivity: Long? = null,
    var connectionCount: Long? = null,
    var online: Boolean? = null,
    var ok: Boolean,
    var presence: String
)
