package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class DndInfoResponse (
    var nextDndEndTs: Long,
    var snoozeEndtime: Long,
    var dndEnabled: Boolean,
    var nextDndStartTs: Long,
    var snoozeEnabled: Boolean,
    var snoozeRemaining: Long,
    var ok: Boolean
)
