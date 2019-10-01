package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ChannelsListResponse (
    var channels: ArrayList<Channel>
): BaseResponse()
