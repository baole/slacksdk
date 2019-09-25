package com.anttek.slack.api

/**
 * Created by duc-d on 8/30/2017.
 */

class ResponseMetadata {
    var next_cursor: String? = null
    var messages: List<String>? = null
}

open class BaseResponse {
    var ok: Boolean = false
    var error: String? = null
    var warning: String? = null
    var ts: String? = null
    var response_metadata: ResponseMetadata? = null
}
