package com.anttek.slack.api.model

class Im (
    var isUserDeleted: Boolean,
    var isAppHome: Boolean? = null,
    var isIm: Boolean,
    var created: Long,
    var isShared: Boolean? = null,
    var id: String,
    var isExtShared: Boolean? = null,
    var priority: Double? = null,
    var isOrgShared: Boolean,
    var user: String
)
