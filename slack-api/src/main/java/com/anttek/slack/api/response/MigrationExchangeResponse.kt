package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class MigrationExchangeResponse (
    var userIdMap: MigrationExchangeUserIdMapResponse? = null,
    var teamId: String,
    var enterpriseId: String,
    var invalidUserIds: ArrayList<String>? = null
): BaseResponse()
