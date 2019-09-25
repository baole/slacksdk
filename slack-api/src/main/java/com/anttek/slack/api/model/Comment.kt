package com.anttek.slack.api.model

class Comment (
    var isStarred: Boolean? = null,
    var created: Long,
    var numStars: Long? = null,
    var isIntro: Boolean,
    var pinnedInfo: Any? = null,
    var comment: String,
    var reactions: ArrayList<Reaction>? = null,
    var id: String,
    var user: String,
    var pinnedTo: ArrayList<String>? = null,
    var timestamp: Long
)
