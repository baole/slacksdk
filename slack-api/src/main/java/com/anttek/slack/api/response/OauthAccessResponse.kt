package com.anttek.slack.api.response

import com.anttek.slack.api.GenericResponse
import com.google.gson.annotations.SerializedName


class Bot {
    lateinit var bot_user_id: String
    lateinit var bot_access_token: String
}

class Team {
    lateinit var id: String
    lateinit var name: String
    var image_48: String? = null
}

class OauthAccessResponse : GenericResponse() {

    lateinit var access_token: String
    lateinit var team: Team
    lateinit var user: Team
    lateinit var team_id: String
    lateinit var team_name: String
    lateinit var bot: Bot
    lateinit var user_id: String
    lateinit var user_name: String

    fun teamId(): String? {
        return if (team != null) team.id else team_id
    }

    fun teamName(): String? {
        return if (team == null) team_name else team!!.name
    }

    fun userName(): String? {
        return if (user == null) user_name else user!!.name
    }

    fun userId(): String? {
        return if (user == null) user_id else user!!.id
    }
}



