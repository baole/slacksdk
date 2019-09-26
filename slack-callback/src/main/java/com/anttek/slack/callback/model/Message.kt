package com.anttek.slack.callback.model

class Message (
    var authedUsers: ArrayList<String>,
    var eventId: String,
    var apiAppId: String,
    var teamId: String,
    var event: MessageEvent,
    var type: String,
    var eventTime: Long,
    var token: String
)
