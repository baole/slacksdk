package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ReactionsListResponse (
    var paging: Paging? = null,
    var items: ArrayList<Any>
): BaseResponse()
