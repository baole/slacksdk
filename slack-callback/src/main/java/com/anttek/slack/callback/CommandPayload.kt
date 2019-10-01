package com.anttek.slack.callback

import com.anttek.slack.api.model.OptionObject

data class CommandTeam(var id: String? = null, var domain: String? = null)

data class CommandUser(var id: String? = null, var name: String? = null)

data class CallbackAction(
        @Deprecated("use action_id")
        var name: String? = null,
        var type: String? = null,
        var value: String? = null,
        val options: List<ActionOption>? = null,
        var action_id: String? = null,
        var block_id: String? = null,
        val selected_option: OptionObject? = null,
        val selected_options: List<ActionOption>? = null,
        val url: String? = null,
        val style: String? = null
)


data class CommandPayload(var actions: MutableList<CallbackAction> = mutableListOf(),
                          var callback_id: String? = null,
                          var team: CommandTeam? = null,
                          var channel: CommandUser? = null,
                          var user: CommandUser? = null,
                          var action_ts: String? = null,
                          var message_ts: String? = null,
                          var message: CommandMessage? = null,
                          var attachment_id: String? = null,
                          var token: String? = null,
                          var response_url: String? = null,
                          var trigger_id: String? = null,
                          var submission: Map<String, String>? = null,
//                     var original_message: String? = null,
                          var type: String? = null
)

data class CommandMessage(val ts: String)

data class CommandRequest(var payload: String? = null)
