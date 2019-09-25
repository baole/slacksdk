package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class FilesListResponse (
    var files: ArrayList<File>,
    var paging: Paging,
    var ok: Boolean
)
