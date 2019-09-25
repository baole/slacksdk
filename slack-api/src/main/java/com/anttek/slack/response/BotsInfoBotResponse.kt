package com.anttek.slack.response
import com.anttek.slack.model.*

class BotsInfoBotResponse (
    var deleted: Boolean,
    var userId: String? = null,
    var name: String,
    var id: String,
    var icons: BotsInfoBotIconsResponse,
    var appId: String,
    var updated: Long
)
