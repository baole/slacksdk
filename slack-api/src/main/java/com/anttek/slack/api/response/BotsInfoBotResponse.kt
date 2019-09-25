package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class BotsInfoBotResponse (
    var deleted: Boolean,
    var userId: String? = null,
    var name: String,
    var id: String,
    var icons: BotsInfoBotIconsResponse,
    var appId: String,
    var updated: Long
)
