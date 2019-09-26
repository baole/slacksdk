package com.anttek.slack.callback.model

class MessageEvent (
    var deletedTs: String,
    var hidden: Boolean,
    var previousMessage: MessageEventPreviousMessage,
    var subtype: String,
    var eventTs: String,
    var channel: String,
    var type: String,
    var ts: String
)
