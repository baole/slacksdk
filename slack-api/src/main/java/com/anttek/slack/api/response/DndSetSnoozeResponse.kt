package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.GenericResponse

class DndSetSnoozeResponse (
    var snoozeEndtime: Long,
    var snoozeEnabled: Boolean,
    var snoozeRemaining: Long
): GenericResponse()
