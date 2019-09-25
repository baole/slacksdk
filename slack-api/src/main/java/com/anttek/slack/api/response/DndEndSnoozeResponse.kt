package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class DndEndSnoozeResponse (
    var nextDndEndTs: Long,
    var dndEnabled: Boolean,
    var nextDndStartTs: Long,
    var snoozeEnabled: Boolean,
    var ok: Boolean
)
