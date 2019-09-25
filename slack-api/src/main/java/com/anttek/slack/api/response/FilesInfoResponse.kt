package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class FilesInfoResponse (
    var editor: String? = null,
    var comments: Comments,
    var file: File,
    var paging: Paging? = null,
    var responseMetadata: ResponseMetadata? = null,
    var ok: Boolean,
    var contentHtml: Any? = null
)
