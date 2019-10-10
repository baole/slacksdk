package com.anttek.slack.api.model

class User{
    lateinit var id: String
    var deleted: Boolean? = false
    var name: String? = null
    var is_admin: Boolean = false
    var image_48: String? = null
    var profile: UserProfile? = null
    var is_bot: Boolean? = null
    var is_app_user: Boolean? = null

    //When a user belongs to a different workspace than the workspace/team associated with your app's token and isn't in any shared channels that your app can see, they will have an is_stranger attribute set to true.
    var is_stranger: Boolean? = null
    //is_restricted indicates the user is a multi-channel guest.
    var is_restricted: Boolean? = null
    //is_ultra_restricted indicates they are a single channel guest.
    var is_ultra_restricted: Boolean? = null

    var tz: String? = null
    var tz_offset: Int? = 0


    fun avatar(): String? {
        return  image_48?: profile?.image48
    }

    fun isAliveHuman(): Boolean {
        return (deleted == null || !deleted!!) && (is_bot == null || !is_bot!!) && (is_app_user == null || !is_app_user!!) && "slackbot" != name
    }

    fun isDeleted() = (deleted != null && deleted!!)

    fun isHuman(): Boolean {
        return (is_bot == null || !is_bot!!) && (is_app_user == null || !is_app_user!!) && !"slackbot".equals(name)
    }
    fun isExternal(): Boolean {
        return is_stranger == true || is_restricted == true || is_ultra_restricted == true
    }
}

