package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ChannelsJoinResponse (
    var alreadyInChannel: Boolean? = null,
    var channel: Channel
): BaseResponse()
