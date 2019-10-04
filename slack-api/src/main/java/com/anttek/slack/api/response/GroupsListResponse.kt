package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class GroupsListResponse (
    var groups: ArrayList<Group>
): GenericResponse()
