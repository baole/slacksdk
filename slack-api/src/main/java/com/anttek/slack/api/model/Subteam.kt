package com.anttek.slack.api.model

class Subteam (
    var dateDelete: Long,
    var dateUpdate: Long,
    var deletedBy: Any,
    var description: String,
    var isExternal: Boolean,
    var handle: String,
    var teamId: String,
    var createdBy: String,
    var users: ArrayList<String>? = null,
    var autoType: Any,
    var prefs: SubteamPrefs,
    var isSubteam: Boolean,
    var userCount: Long? = null,
    var dateCreate: Long,
    var name: String,
    var updatedBy: String,
    var isUsergroup: Boolean,
    var id: String,
    var autoProvision: Boolean,
    var enterpriseSubteamId: String
)
