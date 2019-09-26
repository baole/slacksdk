package com.anttek.slack.callback

class MessagePayload(var user: String? = null,
                     var text: String? = null,
                     var ts: String? = null)

class Token {
    var oauth: List<String>? = null
    var bot: List<String>? = null
}

class EventPayload(var type: String? = null,
                   var event_ts: String? = null,
                   var user: String? = null,
                   var bot_id: String? = null,
                   var subtype: String? = null,
                   var message: MessagePayload? = null,
                   var text: String? = null,
                   var ts: String? = null,
                   var channel: String? = null,
                   var is_move: Int? = null,
                   var attachments: List<Attachment>? = null,
                   var files: List<EventFile>? = null,
                   var tokens: Token? = null
)

class Payload(var token: String? = null,
              var team_id: String? = null,
              var api_app_id: String? = null,
              var event: EventPayload? = null,
              var type: String? = null,
              var authed_users: List<String>? = null,
              var event_id: String? = null,
              var event_time: String? = null)

//https://api.slack.com/types/file
class EventFile(var id: String? = null
                , var timestamp: Long = 0
                , var name: String? = null
                , var title: String? = null
                , var mode: String? = null
                , var mimetype: String? = null
                , var filetype: String? = null
                , var url_private: String? = null
                , var permalink: String? = null
                , var permalink_public: String? = null
                , var is_public: Boolean? = null
                , var is_external: Boolean? = null
                , var preview: String? = null


)
