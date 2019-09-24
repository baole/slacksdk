package com.anttek.slack.response
import com.anttek.slack.model.*

class DndInfoResponse (
    var nextDndEndTs: Long,
    var snoozeEndtime: Long,
    var dndEnabled: Boolean,
    var nextDndStartTs: Long,
    var snoozeEnabled: Boolean,
    var snoozeRemaining: Long,
    var ok: Boolean
)
