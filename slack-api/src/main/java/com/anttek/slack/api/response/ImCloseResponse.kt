package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class ImCloseResponse (
    var alreadyClosed: Boolean? = null,
    var noOp: Boolean? = null
): BaseResponse()
