package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class DndSetSnoozeResponse (
    var snoozeEndtime: Long,
    var snoozeEnabled: Boolean,
    var snoozeRemaining: Long,
    var ok: Boolean
)
