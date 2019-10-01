package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class TeamProfileGetProfileResponse (
    var fields: ArrayList<TeamProfileField>
): BaseResponse()
