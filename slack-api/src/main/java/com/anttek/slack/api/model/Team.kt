package com.anttek.slack.api.model

class Team (
    var overIntegrationsLimit: Boolean? = null,
    var created: Long? = null,
    var isEnterprise: Long? = null,
    var isAssigned: Boolean? = null,
    var icon: Icon,
    var limitTs: Long? = null,
    var description: String? = null,
    var msgEditWindowMins: Long? = null,
    var avatarBaseUrl: String? = null,
    var enterpriseId: String? = null,
    var archived: Boolean? = null,
    var messagesCount: Long? = null,
    var deleted: Boolean? = null,
    var hasComplianceExport: Boolean? = null,
    var dateCreate: Long? = null,
    var discoverable: String? = null,
    var domain: String,
    var name: String,
    var emailDomain: String,
    var id: String,
    var enterpriseName: String? = null,
    var overStorageLimit: Boolean? = null,
    var plan: String? = null
)
