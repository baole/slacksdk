package com.anttek.slack.api.model

class Message (
    var attachments: ArrayList<Any>? = null,
    var clientMsgId: String? = null,
    var purpose: String? = null,
    var upload: Boolean? = null,
    var isIntro: Boolean? = null,
    var userProfile: UserProfileShort? = null,
    var type: String,
    var isDelayedMessage: Boolean? = null,
    var subscribed: Boolean? = null,
    var unreadCount: Long? = null,
    var file: File? = null,
    var subtype: String? = null,
    var replyUsersCount: Long? = null,
    var inviter: String? = null,
    var text: String,
    var displayAsBot: Boolean? = null,
    var botId: Any? = null,
    var latestReply: String? = null,
    var lastRead: String? = null,
    var parentUserId: String? = null,
    var blocks: Blocks? = null,
    var replyUsers: ArrayList<String>? = null,
    var team: String? = null,
    var icons: MessageIcons? = null,
    var replyCount: Long? = null,
    var userTeam: String? = null,
    var pinnedTo: ArrayList<String>? = null,
    var isStarred: Boolean? = null,
    var replies: ArrayList<Any>? = null,
    var oldName: String? = null,
    var sourceTeam: String? = null,
    var threadTs: String? = null,
    var name: String? = null,
    var files: ArrayList<File>? = null,
    var topic: String? = null,
    var comment: Comment? = null,
    var reactions: ArrayList<Reaction>? = null,
    var permalink: String? = null,
    var user: String? = null,
    var ts: String,
    var username: String? = null
)