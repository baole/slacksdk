package com.anttek.slack.callback.model

class MessageEventPreviousMessage (
    var file: MessageEventPreviousMessageFile,
    var subtype: String,
    var comment: Any,
    var text: String,
    var type: String,
    var ts: String
)
