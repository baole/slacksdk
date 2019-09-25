package com.anttek.slack.model

class Reminder (
    var creator: String,
    var recurring: Boolean,
    var completeTs: Long? = null,
    var id: String,
    var text: String,
    var time: Long? = null,
    var user: String
)
