package com.anttek.slack
import com.anttek.slack.model.*
import com.anttek.slack.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SlackApi {
    @POST("groups_open")
    fun groupsOpen(@Query("channel") channel: String
    ): Call<GroupsOpenResponse>

    @GET("apps_permissions_info")
    fun appsPermissionsInfo(@Query("token") token: String
    ): Call<AppsPermissionsInfoResponse>

    @POST("groups_kick")
    fun groupsKick(@Query("user") user: String,
                                @Query("channel") channel: String
    ): Call<GroupsKickResponse>

    @GET("chat_scheduledMessages_list")
    fun chatScheduledMessagesList(@Query("cursor") cursor: String,
                                @Query("limit") limit: Long,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<ChatScheduledMessagesListResponse>

    @GET("pins_list")
    fun pinsList(@Query("token") token: String,
                                @Query("channel") channel: String
    ): Call<PinsListResponse>

    @POST("channels_invite")
    fun channelsInvite(@Query("user") user: String,
                                @Query("channel") channel: String
    ): Call<ChannelsInviteResponse>

    @POST("conversations_setTopic")
    fun conversationsSetTopic(@Query("topic") topic: String,
                                @Query("channel") channel: String
    ): Call<ConversationsSetTopicResponse>

    @GET("channels_replies")
    fun channelsReplies(@Query("thread_ts") threadTs: Double,
                                @Query("token") token: String,
                                @Query("channel") channel: String
    ): Call<ChannelsRepliesResponse>

    @GET("auth_test")
    fun authTest(
    ): Call<AuthTestResponse>

    @GET("oauth_access")
    fun oauthAccess(@Query("code") code: String,
                                @Query("redirect_uri") redirectUri: String,
                                @Query("client_id") clientId: String,
                                @Query("client_secret") clientSecret: String,
                                @Query("single_channel") singleChannel: Boolean
    ): Call<OauthAccessResponse>

    @GET("bots_info")
    fun botsInfo(@Query("token") token: String,
                                @Query("bot") bot: String
    ): Call<BotsInfoResponse>

    @GET("team_info")
    fun teamInfo(@Query("token") token: String,
                                @Query("team") team: String
    ): Call<TeamInfoResponse>

    @POST("conversations_close")
    fun conversationsClose(@Query("channel") channel: String
    ): Call<ConversationsCloseResponse>

    @GET("groups_replies")
    fun groupsReplies(@Query("thread_ts") threadTs: Double,
                                @Query("token") token: String,
                                @Query("channel") channel: String
    ): Call<GroupsRepliesResponse>

    @GET("channels_info")
    fun channelsInfo(@Query("token") token: String,
                                @Query("include_locale") includeLocale: Boolean,
                                @Query("channel") channel: String
    ): Call<ChannelsInfoResponse>

    @POST("conversations_rename")
    fun conversationsRename(@Query("name") name: String,
                                @Query("channel") channel: String
    ): Call<ConversationsRenameResponse>

    @POST("groups_unarchive")
    fun groupsUnarchive(@Query("channel") channel: String
    ): Call<GroupsUnarchiveResponse>

    @GET("files_info")
    fun filesInfo(@Query("count") count: String,
                                @Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("file") file: String,
                                @Query("page") page: String
    ): Call<FilesInfoResponse>

    @POST("conversations_archive")
    fun conversationsArchive(@Query("channel") channel: String
    ): Call<ConversationsArchiveResponse>

    @GET("team_integrationLogs")
    fun teamIntegrationLogs(@Query("count") count: String,
                                @Query("change_type") changeType: String,
                                @Query("app_id") appId: Long,
                                @Query("token") token: String,
                                @Query("user") user: String,
                                @Query("service_id") serviceId: Long,
                                @Query("page") page: String
    ): Call<TeamIntegrationLogsResponse>

    @POST("conversations_join")
    fun conversationsJoin(@Query("channel") channel: String
    ): Call<ConversationsJoinResponse>

    @POST("files_upload")
    fun filesUpload(@Query("channels") channels: String,
                                @Query("title") title: String,
                                @Query("initial_comment") initialComment: String,
                                @Query("filetype") filetype: String,
                                @Query("filename") filename: String,
                                @Query("content") content: String,
                                @Query("token") token: String,
                                @Query("file") file: String,
                                @Query("thread_ts") threadTs: Double
    ): Call<FilesUploadResponse>

    @POST("groups_createChild")
    fun groupsCreateChild(@Query("token") token: String,
                                @Query("channel") channel: String
    ): Call<GroupsCreateChildResponse>

    @GET("channels_list")
    fun channelsList(@Query("exclude_members") excludeMembers: Boolean,
                                @Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("exclude_archived") excludeArchived: Boolean
    ): Call<ChannelsListResponse>

    @GET("conversations_members")
    fun conversationsMembers(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("channel") channel: String
    ): Call<ConversationsMembersResponse>

    @POST("stars_add")
    fun starsAdd(@Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("channel") channel: String,
                                @Query("file") file: String
    ): Call<StarsAddResponse>

    @POST("chat_scheduleMessage")
    fun chatScheduleMessage(@Query("thread_ts") threadTs: Double,
                                @Query("blocks") blocks: String,
                                @Query("attachments") attachments: String,
                                @Query("unfurl_links") unfurlLinks: Boolean,
                                @Query("text") text: String,
                                @Query("link_names") linkNames: Boolean,
                                @Query("unfurl_media") unfurlMedia: Boolean,
                                @Query("parse") parse: String,
                                @Query("as_user") asUser: Boolean,
                                @Query("post_at") postAt: String,
                                @Query("channel") channel: String,
                                @Query("reply_broadcast") replyBroadcast: Boolean
    ): Call<ChatScheduleMessageResponse>

    @POST("chat_unfurl")
    fun chatUnfurl(@Query("user_auth_message") userAuthMessage: String,
                                @Query("user_auth_required") userAuthRequired: Boolean,
                                @Query("unfurls") unfurls: String,
                                @Query("ts") ts: String,
                                @Query("user_auth_url") userAuthUrl: String,
                                @Query("channel") channel: String
    ): Call<ChatUnfurlResponse>

    @GET("apps_permissions_request")
    fun appsPermissionsRequest(@Query("scopes") scopes: String,
                                @Query("token") token: String,
                                @Query("trigger_id") triggerId: String
    ): Call<AppsPermissionsRequestResponse>

    @GET("files_list")
    fun filesList(@Query("count") count: String,
                                @Query("channel") channel: String,
                                @Query("ts_to") tsTo: Double,
                                @Query("ts_from") tsFrom: Double,
                                @Query("token") token: String,
                                @Query("user") user: String,
                                @Query("page") page: String,
                                @Query("types") types: String
    ): Call<FilesListResponse>

    @POST("files_delete")
    fun filesDelete(@Query("file") file: String
    ): Call<FilesDeleteResponse>

    @POST("chat_deleteScheduledMessage")
    fun chatDeleteScheduledMessage(
    ): Call<ChatDeleteScheduledMessageResponse>

    @POST("chat_postMessage")
    fun chatPostMessage(@Query("attachments") attachments: String,
                                @Query("unfurl_links") unfurlLinks: Boolean,
                                @Query("text") text: String,
                                @Query("unfurl_media") unfurlMedia: Boolean,
                                @Query("parse") parse: String,
                                @Query("as_user") asUser: Boolean,
                                @Query("mrkdwn") mrkdwn: Boolean,
                                @Query("channel") channel: String,
                                @Query("username") username: String,
                                @Query("blocks") blocks: String,
                                @Query("icon_emoji") iconEmoji: String,
                                @Query("link_names") linkNames: Boolean,
                                @Query("reply_broadcast") replyBroadcast: Boolean,
                                @Query("thread_ts") threadTs: Double,
                                @Query("icon_url") iconUrl: String
    ): Call<ChatPostMessageResponse>

    @POST("channels_mark")
    fun channelsMark(@Query("ts") ts: Double,
                                @Query("channel") channel: String
    ): Call<ChannelsMarkResponse>

    @GET("users_conversations")
    fun usersConversations(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("user") user: String,
                                @Query("exclude_archived") excludeArchived: Boolean,
                                @Query("types") types: String
    ): Call<UsersConversationsResponse>

    @POST("users_deletePhoto")
    fun usersDeletePhoto(@Query("token") token: String
    ): Call<UsersDeletePhotoResponse>

    @POST("users_setPhoto")
    fun usersSetPhoto(@Query("image") image: String,
                                @Query("crop_w") cropW: Long,
                                @Query("token") token: String,
                                @Query("crop_y") cropY: Long,
                                @Query("crop_x") cropX: Long
    ): Call<UsersSetPhotoResponse>

    @POST("im_open")
    fun imOpen(@Query("return_im") returnIm: Boolean,
                                @Query("user") user: String,
                                @Query("include_locale") includeLocale: Boolean
    ): Call<ImOpenResponse>

    @POST("mpim_mark")
    fun mpimMark(@Query("ts") ts: Double,
                                @Query("channel") channel: String
    ): Call<MpimMarkResponse>

    @POST("channels_unarchive")
    fun channelsUnarchive(@Query("channel") channel: String
    ): Call<ChannelsUnarchiveResponse>

    @GET("apps_permissions_users_request")
    fun appsPermissionsUsersRequest(@Query("scopes") scopes: String,
                                @Query("token") token: String,
                                @Query("user") user: String,
                                @Query("trigger_id") triggerId: String
    ): Call<AppsPermissionsUsersRequestResponse>

    @GET("emoji_list")
    fun emojiList(@Query("token") token: String
    ): Call<EmojiListResponse>

    @POST("usergroups_disable")
    fun usergroupsDisable(@Query("include_count") includeCount: Boolean,
                                @Query("usergroup") usergroup: String
    ): Call<UsergroupsDisableResponse>

    @GET("apps_uninstall")
    fun appsUninstall(@Query("client_secret") clientSecret: String,
                                @Query("token") token: String,
                                @Query("client_id") clientId: String
    ): Call<AppsUninstallResponse>

    @GET("team_accessLogs")
    fun teamAccessLogs(@Query("count") count: String,
                                @Query("token") token: String,
                                @Query("page") page: String,
                                @Query("before") before: Long
    ): Call<TeamAccessLogsResponse>

    @POST("groups_setTopic")
    fun groupsSetTopic(@Query("topic") topic: String,
                                @Query("channel") channel: String
    ): Call<GroupsSetTopicResponse>

    @GET("team_billableInfo")
    fun teamBillableInfo(
    ): Call<TeamBillableInfoResponse>

    @POST("channels_setPurpose")
    fun channelsSetPurpose(@Query("purpose") purpose: String,
                                @Query("channel") channel: String
    ): Call<ChannelsSetPurposeResponse>

    @GET("im_replies")
    fun imReplies(@Query("thread_ts") threadTs: Double,
                                @Query("token") token: String,
                                @Query("channel") channel: String
    ): Call<ImRepliesResponse>

    @GET("search_messages")
    fun searchMessages(@Query("sort_dir") sortDir: String,
                                @Query("query") query: String,
                                @Query("sort") sort: String,
                                @Query("count") count: String,
                                @Query("token") token: String,
                                @Query("highlight") highlight: Boolean,
                                @Query("page") page: String
    ): Call<SearchMessagesResponse>

    @POST("files_comments_delete")
    fun filesCommentsDelete(@Query("id") id: String,
                                @Query("file") file: String
    ): Call<FilesCommentsDeleteResponse>

    @GET("groups_info")
    fun groupsInfo(@Query("token") token: String,
                                @Query("include_locale") includeLocale: Boolean,
                                @Query("channel") channel: String
    ): Call<GroupsInfoResponse>

    @GET("mpim_replies")
    fun mpimReplies(@Query("thread_ts") threadTs: Double,
                                @Query("token") token: String,
                                @Query("channel") channel: String
    ): Call<MpimRepliesResponse>

    @POST("pins_remove")
    fun pinsRemove(@Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("file") file: String,
                                @Query("channel") channel: String
    ): Call<PinsRemoveResponse>

    @GET("conversations_history")
    fun conversationsHistory(@Query("inclusive") inclusive: Boolean,
                                @Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<ConversationsHistoryResponse>

    @POST("reminders_add")
    fun remindersAdd(@Query("text") text: String,
                                @Query("user") user: String,
                                @Query("time") time: String
    ): Call<RemindersAddResponse>

    @POST("reactions_remove")
    fun reactionsRemove(@Query("name") name: String,
                                @Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("file") file: String,
                                @Query("channel") channel: String
    ): Call<ReactionsRemoveResponse>

    @GET("users_identity")
    fun usersIdentity(@Query("token") token: String
    ): Call<UsersIdentityResponse>

    @GET("groups_list")
    fun groupsList(@Query("cursor") cursor: String,
                                @Query("exclude_members") excludeMembers: Boolean,
                                @Query("token") token: String,
                                @Query("exclude_archived") excludeArchived: Boolean,
                                @Query("limit") limit: Long
    ): Call<GroupsListResponse>

    @POST("channels_create")
    fun channelsCreate(@Query("validate") validate: Boolean,
                                @Query("name") name: String
    ): Call<ChannelsCreateResponse>

    @POST("mpim_close")
    fun mpimClose(@Query("channel") channel: String
    ): Call<MpimCloseResponse>

    @POST("users_setActive")
    fun usersSetActive(
    ): Call<UsersSetActiveResponse>

    @POST("usergroups_enable")
    fun usergroupsEnable(@Query("include_count") includeCount: Boolean,
                                @Query("usergroup") usergroup: String
    ): Call<UsergroupsEnableResponse>

    @POST("channels_leave")
    fun channelsLeave(@Query("channel") channel: String
    ): Call<ChannelsLeaveResponse>

    @POST("admin_users_session_reset")
    fun adminUsersSessionReset(
    ): Call<AdminUsersSessionResetResponse>

    @GET("reactions_get")
    fun reactionsGet(@Query("full") full: Boolean,
                                @Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("token") token: String,
                                @Query("file") file: String,
                                @Query("channel") channel: String
    ): Call<ReactionsGetResponse>

    @POST("conversations_invite")
    fun conversationsInvite(@Query("users") users: String,
                                @Query("channel") channel: String
    ): Call<ConversationsInviteResponse>

    @POST("groups_mark")
    fun groupsMark(@Query("ts") ts: Double,
                                @Query("channel") channel: String
    ): Call<GroupsMarkResponse>

    @POST("conversations_create")
    fun conversationsCreate(@Query("user_ids") userIds: String,
                                @Query("name") name: String,
                                @Query("is_private") isPrivate: Boolean
    ): Call<ConversationsCreateResponse>

    @POST("groups_setPurpose")
    fun groupsSetPurpose(@Query("purpose") purpose: String,
                                @Query("channel") channel: String
    ): Call<GroupsSetPurposeResponse>

    @GET("api_test")
    fun apiTest(@Query("foo") foo: String,
                                @Query("error") error: String
    ): Call<ApiTestResponse>

    @GET("chat_getPermalink")
    fun chatGetPermalink(@Query("token") token: String,
                                @Query("message_ts") messageTs: Double,
                                @Query("channel") channel: String
    ): Call<ChatGetPermalinkResponse>

    @GET("apps_permissions_scopes_list")
    fun appsPermissionsScopesList(@Query("token") token: String
    ): Call<AppsPermissionsScopesListResponse>

    @GET("users_list")
    fun usersList(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("include_locale") includeLocale: Boolean
    ): Call<UsersListResponse>

    @GET("dnd_teamInfo")
    fun dndTeamInfo(@Query("token") token: String,
                                @Query("users") users: String
    ): Call<DndTeamInfoResponse>

    @POST("chat_postEphemeral")
    fun chatPostEphemeral(@Query("thread_ts") threadTs: Double,
                                @Query("blocks") blocks: String,
                                @Query("attachments") attachments: String,
                                @Query("as_user") asUser: Boolean,
                                @Query("parse") parse: String,
                                @Query("text") text: String,
                                @Query("user") user: String,
                                @Query("link_names") linkNames: Boolean,
                                @Query("channel") channel: String
    ): Call<ChatPostEphemeralResponse>

    @GET("groups_history")
    fun groupsHistory(@Query("count") count: Long,
                                @Query("unreads") unreads: Boolean,
                                @Query("inclusive") inclusive: Boolean,
                                @Query("token") token: String,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<GroupsHistoryResponse>

    @GET("im_list")
    fun imList(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long
    ): Call<ImListResponse>

    @GET("mpim_list")
    fun mpimList(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long
    ): Call<MpimListResponse>

    @POST("chat_meMessage")
    fun chatMeMessage(@Query("text") text: String,
                                @Query("channel") channel: String
    ): Call<ChatMeMessageResponse>

    @POST("channels_join")
    fun channelsJoin(@Query("validate") validate: Boolean,
                                @Query("name") name: String
    ): Call<ChannelsJoinResponse>

    @GET("conversations_info")
    fun conversationsInfo(@Query("include_num_members") includeNumMembers: Boolean,
                                @Query("token") token: String,
                                @Query("channel") channel: String,
                                @Query("include_locale") includeLocale: Boolean
    ): Call<ConversationsInfoResponse>

    @POST("usergroups_update")
    fun usergroupsUpdate(@Query("handle") handle: String,
                                @Query("description") description: String,
                                @Query("channels") channels: String,
                                @Query("include_count") includeCount: Boolean,
                                @Query("usergroup") usergroup: String,
                                @Query("name") name: String
    ): Call<UsergroupsUpdateResponse>

    @POST("dnd_endSnooze")
    fun dndEndSnooze(
    ): Call<DndEndSnoozeResponse>

    @POST("groups_create")
    fun groupsCreate(@Query("validate") validate: Boolean,
                                @Query("name") name: String
    ): Call<GroupsCreateResponse>

    @POST("channels_rename")
    fun channelsRename(@Query("validate") validate: Boolean,
                                @Query("name") name: String,
                                @Query("channel") channel: String
    ): Call<ChannelsRenameResponse>

    @POST("chat_update")
    fun chatUpdate(@Query("blocks") blocks: String,
                                @Query("attachments") attachments: String,
                                @Query("text") text: String,
                                @Query("ts") ts: Double,
                                @Query("parse") parse: String,
                                @Query("as_user") asUser: Boolean,
                                @Query("link_names") linkNames: Boolean,
                                @Query("channel") channel: String
    ): Call<ChatUpdateResponse>

    @POST("files_revokePublicURL")
    fun filesRevokePublicURL(@Query("file") file: String
    ): Call<FilesRevokePublicURLResponse>

    @POST("conversations_unarchive")
    fun conversationsUnarchive(@Query("channel") channel: String
    ): Call<ConversationsUnarchiveResponse>

    @GET("team_profile_get")
    fun teamProfileGet(@Query("token") token: String,
                                @Query("visibility") visibility: String
    ): Call<TeamProfileGetResponse>

    @GET("conversations_list")
    fun conversationsList(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("exclude_archived") excludeArchived: Boolean,
                                @Query("types") types: String
    ): Call<ConversationsListResponse>

    @POST("usergroups_create")
    fun usergroupsCreate(@Query("handle") handle: String,
                                @Query("description") description: String,
                                @Query("channels") channels: String,
                                @Query("include_count") includeCount: Boolean,
                                @Query("name") name: String
    ): Call<UsergroupsCreateResponse>

    @GET("channels_history")
    fun channelsHistory(@Query("count") count: Long,
                                @Query("unreads") unreads: Boolean,
                                @Query("inclusive") inclusive: Boolean,
                                @Query("token") token: String,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<ChannelsHistoryResponse>

    @GET("stars_list")
    fun starsList(@Query("count") count: String,
                                @Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("page") page: String
    ): Call<StarsListResponse>

    @POST("groups_invite")
    fun groupsInvite(@Query("user") user: String,
                                @Query("channel") channel: String
    ): Call<GroupsInviteResponse>

    @POST("groups_archive")
    fun groupsArchive(@Query("channel") channel: String
    ): Call<GroupsArchiveResponse>

    @GET("usergroups_list")
    fun usergroupsList(@Query("include_users") includeUsers: Boolean,
                                @Query("token") token: String,
                                @Query("include_count") includeCount: Boolean,
                                @Query("include_disabled") includeDisabled: Boolean
    ): Call<UsergroupsListResponse>

    @POST("users_setPresence")
    fun usersSetPresence(@Query("presence") presence: String
    ): Call<UsersSetPresenceResponse>

    @POST("files_sharedPublicURL")
    fun filesSharedPublicURL(@Query("file") file: String
    ): Call<FilesSharedPublicURLResponse>

    @POST("groups_leave")
    fun groupsLeave(@Query("channel") channel: String
    ): Call<GroupsLeaveResponse>

    @POST("pins_add")
    fun pinsAdd(@Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("file") file: String,
                                @Query("channel") channel: String
    ): Call<PinsAddResponse>

    @POST("conversations_leave")
    fun conversationsLeave(@Query("channel") channel: String
    ): Call<ConversationsLeaveResponse>

    @GET("users_profile_get")
    fun usersProfileGet(@Query("token") token: String,
                                @Query("include_labels") includeLabels: Boolean,
                                @Query("user") user: String
    ): Call<UsersProfileGetResponse>

    @POST("channels_kick")
    fun channelsKick(@Query("user") user: String,
                                @Query("channel") channel: String
    ): Call<ChannelsKickResponse>

    @POST("im_mark")
    fun imMark(@Query("channel") channel: String,
                                @Query("ts") ts: Double
    ): Call<ImMarkResponse>

    @POST("reactions_add")
    fun reactionsAdd(@Query("name") name: String,
                                @Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("file") file: String,
                                @Query("channel") channel: String
    ): Call<ReactionsAddResponse>

    @POST("dnd_setSnooze")
    fun dndSetSnooze(
    ): Call<DndSetSnoozeResponse>

    @POST("im_close")
    fun imClose(
    ): Call<ImCloseResponse>

    @POST("conversations_kick")
    fun conversationsKick(@Query("user") user: String,
                                @Query("channel") channel: String
    ): Call<ConversationsKickResponse>

    @POST("reminders_delete")
    fun remindersDelete(@Query("reminder") reminder: String
    ): Call<RemindersDeleteResponse>

    @GET("im_history")
    fun imHistory(@Query("count") count: Long,
                                @Query("unreads") unreads: Boolean,
                                @Query("inclusive") inclusive: Boolean,
                                @Query("token") token: String,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<ImHistoryResponse>

    @POST("conversations_open")
    fun conversationsOpen(@Query("return_im") returnIm: Boolean,
                                @Query("users") users: String,
                                @Query("channel") channel: String
    ): Call<ConversationsOpenResponse>

    @POST("groups_rename")
    fun groupsRename(@Query("validate") validate: Boolean,
                                @Query("name") name: String,
                                @Query("channel") channel: String
    ): Call<GroupsRenameResponse>

    @GET("reactions_list")
    fun reactionsList(@Query("count") count: String,
                                @Query("full") full: Boolean,
                                @Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("user") user: String,
                                @Query("page") page: String
    ): Call<ReactionsListResponse>

    @POST("mpim_open")
    fun mpimOpen(@Query("users") users: String
    ): Call<MpimOpenResponse>

    @POST("chat_delete")
    fun chatDelete(@Query("as_user") asUser: Boolean,
                                @Query("ts") ts: Double,
                                @Query("channel") channel: String
    ): Call<ChatDeleteResponse>

    @GET("rtm_connect")
    fun rtmConnect(@Query("presence_sub") presenceSub: Boolean,
                                @Query("token") token: String,
                                @Query("batch_presence_aware") batchPresenceAware: Boolean
    ): Call<RtmConnectResponse>

    @GET("oauth_token")
    fun oauthToken(@Query("client_secret") clientSecret: String,
                                @Query("code") code: String,
                                @Query("single_channel") singleChannel: Boolean,
                                @Query("client_id") clientId: String,
                                @Query("redirect_uri") redirectUri: String
    ): Call<OauthTokenResponse>

    @GET("apps_permissions_users_list")
    fun appsPermissionsUsersList(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long
    ): Call<AppsPermissionsUsersListResponse>

    @GET("conversations_replies")
    fun conversationsReplies(@Query("inclusive") inclusive: Boolean,
                                @Query("ts") ts: Double,
                                @Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<ConversationsRepliesResponse>

    @GET("reminders_list")
    fun remindersList(@Query("token") token: String
    ): Call<RemindersListResponse>

    @POST("usergroups_users_update")
    fun usergroupsUsersUpdate(@Query("users") users: String,
                                @Query("include_count") includeCount: Boolean,
                                @Query("usergroup") usergroup: String
    ): Call<UsergroupsUsersUpdateResponse>

    @GET("users_info")
    fun usersInfo(@Query("token") token: String,
                                @Query("user") user: String,
                                @Query("include_locale") includeLocale: Boolean
    ): Call<UsersInfoResponse>

    @GET("dnd_info")
    fun dndInfo(@Query("token") token: String,
                                @Query("user") user: String
    ): Call<DndInfoResponse>

    @POST("reminders_complete")
    fun remindersComplete(@Query("reminder") reminder: String
    ): Call<RemindersCompleteResponse>

    @GET("mpim_history")
    fun mpimHistory(@Query("count") count: Long,
                                @Query("unreads") unreads: Boolean,
                                @Query("inclusive") inclusive: Boolean,
                                @Query("token") token: String,
                                @Query("oldest") oldest: Double,
                                @Query("channel") channel: String,
                                @Query("latest") latest: Double
    ): Call<MpimHistoryResponse>

    @GET("usergroups_users_list")
    fun usergroupsUsersList(
    ): Call<UsergroupsUsersListResponse>

    @GET("reminders_info")
    fun remindersInfo(@Query("token") token: String,
                                @Query("reminder") reminder: String
    ): Call<RemindersInfoResponse>

    @POST("channels_archive")
    fun channelsArchive(@Query("channel") channel: String
    ): Call<ChannelsArchiveResponse>

    @POST("channels_setTopic")
    fun channelsSetTopic(@Query("topic") topic: String,
                                @Query("channel") channel: String
    ): Call<ChannelsSetTopicResponse>

    @GET("migration_exchange")
    fun migrationExchange(
    ): Call<MigrationExchangeResponse>

    @GET("dialog_open")
    fun dialogOpen(
    ): Call<DialogOpenResponse>

    @GET("users_getPresence")
    fun usersGetPresence(@Query("token") token: String,
                                @Query("user") user: String
    ): Call<UsersGetPresenceResponse>

    @GET("apps_permissions_resources_list")
    fun appsPermissionsResourcesList(@Query("cursor") cursor: String,
                                @Query("token") token: String,
                                @Query("limit") limit: Long
    ): Call<AppsPermissionsResourcesListResponse>

    @POST("conversations_setPurpose")
    fun conversationsSetPurpose(@Query("purpose") purpose: String,
                                @Query("channel") channel: String
    ): Call<ConversationsSetPurposeResponse>

    @POST("stars_remove")
    fun starsRemove(@Query("file_comment") fileComment: String,
                                @Query("timestamp") timestamp: Double,
                                @Query("channel") channel: String,
                                @Query("file") file: String
    ): Call<StarsRemoveResponse>

    @POST("dnd_endDnd")
    fun dndEndDnd(
    ): Call<DndEndDndResponse>

    @GET("users_lookupByEmail")
    fun usersLookupByEmail(@Query("token") token: String,
                                @Query("email") email: String
    ): Call<UsersLookupByEmailResponse>

    @POST("users_profile_set")
    fun usersProfileSet(@Query("profile") profile: String,
                                @Query("user") user: String,
                                @Query("value") value: String,
                                @Query("name") name: String
    ): Call<UsersProfileSetResponse>

    @GET("auth_revoke")
    fun authRevoke(@Query("test") test: Boolean,
                                @Query("token") token: String
    ): Call<AuthRevokeResponse>

}
