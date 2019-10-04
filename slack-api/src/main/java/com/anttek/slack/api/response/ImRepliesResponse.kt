package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ImRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean
): GenericResponse()
