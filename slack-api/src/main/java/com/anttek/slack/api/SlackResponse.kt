package com.anttek.slack.api

import java.io.IOException

data class SlackResponse<out T: GenericResponse>(val result: T? = null, val httpCode: Int = 0, val exception: IOException? = null) {
    fun isSuccess() = result != null
    fun successResult() = result!!
}
