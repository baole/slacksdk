package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class GroupsRepliesResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean? = null
): GenericResponse()
