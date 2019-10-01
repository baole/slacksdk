package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ConversationsRepliesResponse (
    var messages: ArrayList<Any>,
    var hasMore: Boolean? = null
): BaseResponse()
