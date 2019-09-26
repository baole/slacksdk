package com.anttek.slack.api.response

import com.anttek.slack.api.model.*


class Bot(
        var bot_user_id: String? = null,
        var bot_access_token: String? = null
)

class Team(
        var id: String? = null,
        var name: String? = null,
        var image_48: String? = null
)

class OauthAccessResponse(
        var ok: Boolean,
        var access_token: String? = null,
        var team: Team? = null,
        var user: Team? = null,
        var error: String? = null,
        var team_id: String? = null,
        var team_name: String? = null,
        var bot: Bot? = null,
        var user_id: String? = null,
        var user_name: String? = null
)


