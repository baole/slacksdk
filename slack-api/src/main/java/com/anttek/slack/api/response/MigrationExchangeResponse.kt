package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class MigrationExchangeResponse (
    var userIdMap: MigrationExchangeUserIdMapResponse? = null,
    var teamId: String,
    var enterpriseId: String,
    var ok: Boolean,
    var invalidUserIds: ArrayList<String>? = null
)
