package com.anttek.slack.model

class Paging (
    var perPage: Long? = null,
    var total: Long,
    var pages: Long? = null,
    var spill: Long? = null,
    var count: Long? = null,
    var page: Long
)
