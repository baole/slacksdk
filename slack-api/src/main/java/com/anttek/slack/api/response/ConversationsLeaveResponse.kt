package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ConversationsLeaveResponse (
    var notInChannel: Boolean? = null
): GenericResponse()
