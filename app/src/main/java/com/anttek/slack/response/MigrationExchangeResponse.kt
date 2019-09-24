package com.anttek.slack.response
import com.anttek.slack.model.*

class MigrationExchangeResponse (
    var userIdMap: MigrationExchangeUserIdMapResponse? = null,
    var teamId: String,
    var enterpriseId: String,
    var ok: Boolean,
    var invalidUserIds: ArrayList<String>? = null
)
