package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class FilesInfoResponse (
    var editor: String? = null,
    var comments: Comments,
    var file: File,
    var paging: Paging? = null,
    var contentHtml: Any? = null
): GenericResponse()
