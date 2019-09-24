package com.anttek.slack.response
import com.anttek.slack.model.*

class DndEndSnoozeResponse (
    var nextDndEndTs: Long,
    var dndEnabled: Boolean,
    var nextDndStartTs: Long,
    var snoozeEnabled: Boolean,
    var ok: Boolean
)
