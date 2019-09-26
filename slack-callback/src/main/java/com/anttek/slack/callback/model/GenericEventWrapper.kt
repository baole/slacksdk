package com.anttek.slack.callback.model

class GenericEventWrapper (
    var authedUsers: ArrayList<String>,
    var eventId: String   /**  Use this to distinguish which app the event belongs to if you use multiple apps with the same Request URL. */
,
    var apiAppId: String,
    var teamId: String,
    var event: GenericEventWrapperEvent,
    var type: String,
    var eventTime: Long,
    var token: String
) {
    companion object {
        const val EVENT_STAR_REMOVED = "star.removed"
        const val EVENT_FILE_COMMENT_EDITED = "file.comment.edited"
        const val EVENT_EMAIL_DOMAIN_CHANGED = "email.domain.changed"
        const val EVENT_FILE_PUBLIC = "file.public"
        const val EVENT_RESOURCES_REMOVED = "resources.removed"
        const val EVENT_APP_UNINSTALLED = "app.uninstalled"
        const val EVENT_FILE_COMMENT_ADDED = "file.comment.added"
        const val EVENT_GROUP_ARCHIVE = "group.archive"
        const val EVENT_GROUP_RENAME = "group.rename"
        const val EVENT_PIN_REMOVED = "pin.removed"
        const val EVENT_IM_CREATED = "im.created"
        const val EVENT_IM_HISTORY_CHANGED = "im.history.changed"
        const val EVENT_SUBTEAM_CREATED = "subteam.created"
        const val EVENT_FILE_CREATED = "file.created"
        const val EVENT_SCOPE_GRANTED = "scope.granted"
        const val EVENT_IM_CLOSE = "im.close"
        const val EVENT_SUBTEAM_UPDATED = "subteam.updated"
        const val EVENT_MESSAGE_MPIM = "message.mpim"
        const val EVENT_CHANNEL_CREATED = "channel.created"
        const val EVENT_GROUP_LEFT = "group.left"
        const val EVENT_SUBTEAM_SELF_REMOVED = "subteam.self.removed"
        const val EVENT_MESSAGE_APP_HOME = "message.app.home"
        const val EVENT_GROUP_HISTORY_CHANGED = "group.history.changed"
        const val EVENT_STAR_ADDED = "star.added"
        const val EVENT_SUBTEAM_MEMBERS_CHANGED = "subteam.members.changed"
        const val EVENT_CHANNEL_UNARCHIVE = "channel.unarchive"
        const val EVENT_URL_VERIFICATION = "url.verification"
        const val EVENT_CHANNEL_ARCHIVE = "channel.archive"
        const val EVENT_CHANNEL_HISTORY_CHANGED = "channel.history.changed"
        const val EVENT_FILE_UNSHARED = "file.unshared"
        const val EVENT_CHANNEL_DELETED = "channel.deleted"
        const val EVENT_CHANNEL_RENAME = "channel.rename"
        const val EVENT_SUBTEAM_SELF_ADDED = "subteam.self.added"
        const val EVENT_APP_MENTION = "app.mention"
        const val EVENT_FILE_CHANGE = "file.change"
        const val EVENT_REACTION_REMOVED = "reaction.removed"
        const val EVENT_USER_CHANGE = "user.change"
        const val EVENT_MESSAGE_IM = "message.im"
        const val EVENT_TEAM_JOIN = "team.join"
        const val EVENT_TEAM_DOMAIN_CHANGE = "team.domain.change"
        const val EVENT_TOKENS_REVOKED = "tokens.revoked"
        const val EVENT_SCOPE_DENIED = "scope.denied"
        const val EVENT_FILE_DELETED = "file.deleted"
        const val EVENT_FILE_COMMENT_DELETED = "file.comment.deleted"
        const val EVENT_REACTION_ADDED = "reaction.added"
        const val EVENT_PIN_ADDED = "pin.added"
        const val EVENT_GRID_MIGRATION_FINISHED = "grid.migration.finished"
        const val EVENT_FILE_SHARED = "file.shared"
        const val EVENT_MESSAGE_GROUPS = "message.groups"
        const val EVENT_GROUP_CLOSE = "group.close"
        const val EVENT_GROUP_OPEN = "group.open"
        const val EVENT_CHANNEL_LEFT = "channel.left"
        const val EVENT_RESOURCES_ADDED = "resources.added"
        const val EVENT_GROUP_UNARCHIVE = "group.unarchive"
        const val EVENT_MEMBER_LEFT_CHANNEL = "member.left.channel"
        const val EVENT_MESSAGE = "message"
        const val EVENT_APP_RATE_LIMITED = "app.rate.limited"
        const val EVENT_GRID_MIGRATION_STARTED = "grid.migration.started"
        const val EVENT_MEMBER_JOINED_CHANNEL = "member.joined.channel"
        const val EVENT_MESSAGE_CHANNELS = "message.channels"
        const val EVENT_EMOJI_CHANGED = "emoji.changed"
        const val EVENT_LINK_SHARED = "link.shared"
        const val EVENT_DND_UPDATED = "dnd.updated"
        const val EVENT_DND_UPDATED_USER = "dnd.updated.user"
        const val EVENT_TEAM_RENAME = "team.rename"
        const val EVENT_IM_OPEN = "im.open"
    }
}
