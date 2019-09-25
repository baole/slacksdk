package com.anttek.slack.api.model

class TeamProfileField (
    var ordering: Double,
    var hint: String,
    var possibleValues: ArrayList<String>? = null,
    var isHidden: Boolean? = null,
    var options: ArrayList<String>,
    var id: String,
    var label: String,
    var type: String,
    var fieldName: String? = null
)
