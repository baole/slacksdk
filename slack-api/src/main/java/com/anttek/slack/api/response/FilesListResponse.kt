package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class FilesListResponse (
    var files: ArrayList<File>,
    var paging: Paging
): BaseResponse()
