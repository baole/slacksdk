package com.anttek.slack.response
import com.anttek.slack.model.*

class DndSetSnoozeResponse (
    var snoozeEndtime: Long,
    var snoozeEnabled: Boolean,
    var snoozeRemaining: Long,
    var ok: Boolean
)
