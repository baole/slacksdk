package com.anttek.slack.api.model

class Group (
    var lastRead: String? = null,
    var creator: String,
    var isMpim: Boolean? = null,
    var isOpen: Boolean? = null,
    var purpose: GroupPurpose,
    var created: Long,
    var isMoved: Long? = null,
    var isPendingExtShared: Boolean? = null,
    var nameNormalized: String,
    var priority: Double? = null,
    var unreadCountDisplay: Long? = null,
    var isGroup: Boolean,
    var unreadCount: Long? = null,
    var isDeleted: Boolean? = null,
    var isArchived: Boolean? = null,
    var members: ArrayList<String>,
    var numMembers: Long? = null,
    var name: String,
    var topic: GroupTopic,
    var id: String,
    var latest: Any? = null
)
