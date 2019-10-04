package com.anttek.slack.api

/**
 * Created by duc-d on 8/30/2017.
 */


open class GenericResponse {
    var ok: Boolean = false
    var error: String? = null
    var warning: String? = null
    var ts: String? = null
    var response_metadata: ResponseMetadata? = null
}
