package com.anttek.slack.response
import com.anttek.slack.model.*

class UsersGetPresenceResponse (
    var autoAway: Boolean? = null,
    var manualAway: Boolean? = null,
    var lastActivity: Long? = null,
    var connectionCount: Long? = null,
    var online: Boolean? = null,
    var ok: Boolean,
    var presence: String
)
