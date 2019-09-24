package com.anttek.slack.response
import com.anttek.slack.model.*

class FilesListResponse (
    var files: ArrayList<File>,
    var paging: Paging,
    var ok: Boolean
)
