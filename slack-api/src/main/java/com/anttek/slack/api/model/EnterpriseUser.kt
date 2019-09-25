package com.anttek.slack.api.model

class EnterpriseUser (
    var isAdmin: Boolean,
    var teams: ArrayList<String>,
    var isOwner: Boolean,
    var id: String,
    var enterpriseId: String,
    var enterpriseName: String
)
