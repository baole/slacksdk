package com.anttek.slack

data class SlackResponse<T>(val result: T? = null, val httpCode: Int = 0, val throwable: Throwable? = null)
