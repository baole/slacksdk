package com.anttek.slack.api

import java.io.IOException

data class SlackResponse<T>(val result: T? = null, val httpCode: Int = 0, val exception: IOException? = null)
