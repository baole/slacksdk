package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ImHistoryResponse (
    var messages: ArrayList<Message>,
    var hasMore: Boolean
): BaseResponse()
