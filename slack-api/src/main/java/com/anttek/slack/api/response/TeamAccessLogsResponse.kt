package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class TeamAccessLogsResponse (
    var paging: Paging,
    var logins: ArrayList<Any>
): BaseResponse()
