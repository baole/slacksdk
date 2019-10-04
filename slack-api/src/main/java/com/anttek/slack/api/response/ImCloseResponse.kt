package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class ImCloseResponse (
    var alreadyClosed: Boolean? = null,
    var noOp: Boolean? = null
): GenericResponse()
