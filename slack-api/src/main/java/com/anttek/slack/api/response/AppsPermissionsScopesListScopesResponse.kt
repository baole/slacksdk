package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class AppsPermissionsScopesListScopesResponse (
    var im: Scopes? = null,
    var mpim: Scopes? = null,
    var channel: Scopes? = null,
    var appHome: Scopes? = null,
    var team: Scopes? = null,
    var user: Scopes? = null,
    var group: Scopes? = null
): GenericResponse()
