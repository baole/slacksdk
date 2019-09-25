package com.anttek.slack
import com.anttek.slack.model.*
import com.anttek.slack.request.*
import com.anttek.slack.response.*
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Body
import retrofit2.http.QueryMap

interface SlackService {
    @POST("groups.open")
    fun groupsOpen(@Header("Authorization") authorization: String, @Body request: GroupsOpenRequest): Call<GroupsOpenResponse>

    @GET("apps.permissions.info")
    fun appsPermissionsInfo(@Query("token") token: String): Call<AppsPermissionsInfoResponse>

    @POST("groups.kick")
    fun groupsKick(@Header("Authorization") authorization: String, @Body request: GroupsKickRequest): Call<GroupsKickResponse>

    @GET("chat.scheduledMessages.list")
    fun chatScheduledMessagesList(@Query("token") token: String,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ChatScheduledMessagesListResponse>

    @GET("pins.list")
    fun pinsList(@Query("token") token: String,
                                @Query("channel") channel: String? = null): Call<PinsListResponse>

    @POST("channels.invite")
    fun channelsInvite(@Header("Authorization") authorization: String, @Body request: ChannelsInviteRequest): Call<ChannelsInviteResponse>

    @POST("conversations.setTopic")
    fun conversationsSetTopic(@Header("Authorization") authorization: String, @Body request: ConversationsSetTopicRequest): Call<ConversationsSetTopicResponse>

    @GET("channels.replies")
    fun channelsReplies(@Query("token") token: String,
                                @Query("thread_ts") threadTs: Double? = null,
                                @Query("channel") channel: String? = null): Call<ChannelsRepliesResponse>

    @GET("auth.test")
    fun authTest(): Call<AuthTestResponse>

    @GET("oauth.access")
    fun oauthAccess(@Query("code") code: String? = null,
                                @Query("redirect_uri") redirectUri: String? = null,
                                @Query("client_id") clientId: String? = null,
                                @Query("client_secret") clientSecret: String? = null,
                                @Query("single_channel") singleChannel: Boolean? = null): Call<OauthAccessResponse>

    @GET("bots.info")
    fun botsInfo(@Query("token") token: String,
                                @Query("bot") bot: String? = null): Call<BotsInfoResponse>

    @GET("team.info")
    fun teamInfo(@Query("token") token: String,
                                @Query("team") team: String? = null): Call<TeamInfoResponse>

    @POST("conversations.close")
    fun conversationsClose(@Header("Authorization") authorization: String, @Body request: ConversationsCloseRequest): Call<ConversationsCloseResponse>

    @GET("groups.replies")
    fun groupsReplies(@Query("token") token: String,
                                @Query("thread_ts") threadTs: Double? = null,
                                @Query("channel") channel: String? = null): Call<GroupsRepliesResponse>

    @GET("channels.info")
    fun channelsInfo(@Query("token") token: String,
                                @Query("include_locale") includeLocale: Boolean? = null,
                                @Query("channel") channel: String? = null): Call<ChannelsInfoResponse>

    @POST("conversations.rename")
    fun conversationsRename(@Header("Authorization") authorization: String, @Body request: ConversationsRenameRequest): Call<ConversationsRenameResponse>

    @POST("groups.unarchive")
    fun groupsUnarchive(@Header("Authorization") authorization: String, @Body request: GroupsUnarchiveRequest): Call<GroupsUnarchiveResponse>

    @GET("files.info")
    fun filesInfo(@Query("token") token: String,
                                @Query("count") count: String? = null,
                                @Query("file") file: String? = null,
                                @Query("page") page: String? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<FilesInfoResponse>

    @POST("conversations.archive")
    fun conversationsArchive(@Header("Authorization") authorization: String, @Body request: ConversationsArchiveRequest): Call<ConversationsArchiveResponse>

    @GET("team.integrationLogs")
    fun teamIntegrationLogs(@Query("token") token: String,
                                @Query("count") count: String? = null,
                                @Query("change_type") changeType: String? = null,
                                @Query("app_id") appId: Long? = null,
                                @Query("user") user: String? = null,
                                @Query("service_id") serviceId: Long? = null,
                                @Query("page") page: String? = null): Call<TeamIntegrationLogsResponse>

    @POST("conversations.join")
    fun conversationsJoin(@Header("Authorization") authorization: String, @Body request: ConversationsJoinRequest): Call<ConversationsJoinResponse>

    @POST("files.upload")
    fun filesUpload(@Header("Authorization") authorization: String, @Body request: FilesUploadRequest): Call<FilesUploadResponse>

    @POST("groups.createChild")
    fun groupsCreateChild(@Header("Authorization") authorization: String, @Body request: GroupsCreateChildRequest): Call<GroupsCreateChildResponse>

    @GET("channels.list")
    fun channelsList(@Query("token") token: String,
                                @Query("exclude_members") excludeMembers: Boolean? = null,
                                @Query("exclude_archived") excludeArchived: Boolean? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ChannelsListResponse>

    @GET("conversations.members")
    fun conversationsMembers(@Query("token") token: String,
                                @Query("channel") channel: String? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ConversationsMembersResponse>

    @POST("stars.add")
    fun starsAdd(@Header("Authorization") authorization: String, @Body request: StarsAddRequest): Call<StarsAddResponse>

    @POST("chat.scheduleMessage")
    fun chatScheduleMessage(@Header("Authorization") authorization: String, @Body request: ChatScheduleMessageRequest): Call<ChatScheduleMessageResponse>

    @POST("chat.unfurl")
    fun chatUnfurl(@Header("Authorization") authorization: String, @Body request: ChatUnfurlRequest): Call<ChatUnfurlResponse>

    @GET("apps.permissions.request")
    fun appsPermissionsRequest(@Query("token") token: String,
                                @Query("scopes") scopes: String? = null,
                                @Query("trigger_id") triggerId: String? = null): Call<AppsPermissionsRequestResponse>

    @GET("files.list")
    fun filesList(@Query("token") token: String,
                                @Query("count") count: String? = null,
                                @Query("channel") channel: String? = null,
                                @Query("ts_to") tsTo: Double? = null,
                                @Query("ts_from") tsFrom: Double? = null,
                                @Query("user") user: String? = null,
                                @Query("page") page: String? = null,
                                @Query("types") types: String? = null): Call<FilesListResponse>

    @POST("files.delete")
    fun filesDelete(@Header("Authorization") authorization: String, @Body request: FilesDeleteRequest): Call<FilesDeleteResponse>

    @POST("chat.deleteScheduledMessage")
    fun chatDeleteScheduledMessage(@Header("Authorization") authorization: String, @Body request: ChatDeleteScheduledMessageRequest): Call<ChatDeleteScheduledMessageResponse>

    @POST("chat.postMessage")
    fun chatPostMessage(@Header("Authorization") authorization: String, @Body request: ChatPostMessageRequest): Call<ChatPostMessageResponse>

    @POST("channels.mark")
    fun channelsMark(@Header("Authorization") authorization: String, @Body request: ChannelsMarkRequest): Call<ChannelsMarkResponse>

    @GET("users.conversations")
    fun usersConversations(@Query("token") token: String,
                                @Query("user") user: String? = null,
                                @Query("exclude_archived") excludeArchived: Boolean? = null,
                                @Query("types") types: String? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<UsersConversationsResponse>

    @POST("users.deletePhoto")
    fun usersDeletePhoto(@Header("Authorization") authorization: String, @Body request: UsersDeletePhotoRequest): Call<UsersDeletePhotoResponse>

    @POST("users.setPhoto")
    fun usersSetPhoto(@Header("Authorization") authorization: String, @Body request: UsersSetPhotoRequest): Call<UsersSetPhotoResponse>

    @POST("im.open")
    fun imOpen(@Header("Authorization") authorization: String, @Body request: ImOpenRequest): Call<ImOpenResponse>

    @POST("mpim.mark")
    fun mpimMark(@Header("Authorization") authorization: String, @Body request: MpimMarkRequest): Call<MpimMarkResponse>

    @POST("channels.unarchive")
    fun channelsUnarchive(@Header("Authorization") authorization: String, @Body request: ChannelsUnarchiveRequest): Call<ChannelsUnarchiveResponse>

    @GET("apps.permissions.users.request")
    fun appsPermissionsUsersRequest(@Query("token") token: String,
                                @Query("scopes") scopes: String? = null,
                                @Query("user") user: String? = null,
                                @Query("trigger_id") triggerId: String? = null): Call<AppsPermissionsUsersRequestResponse>

    @GET("emoji.list")
    fun emojiList(@Query("token") token: String): Call<EmojiListResponse>

    @POST("usergroups.disable")
    fun usergroupsDisable(@Header("Authorization") authorization: String, @Body request: UsergroupsDisableRequest): Call<UsergroupsDisableResponse>

    @GET("apps.uninstall")
    fun appsUninstall(@Query("token") token: String,
                                @Query("client_secret") clientSecret: String? = null,
                                @Query("client_id") clientId: String? = null): Call<AppsUninstallResponse>

    @GET("team.accessLogs")
    fun teamAccessLogs(@Query("token") token: String,
                                @Query("count") count: String? = null,
                                @Query("page") page: String? = null,
                                @Query("before") before: Long? = null): Call<TeamAccessLogsResponse>

    @POST("groups.setTopic")
    fun groupsSetTopic(@Header("Authorization") authorization: String, @Body request: GroupsSetTopicRequest): Call<GroupsSetTopicResponse>

    @GET("team.billableInfo")
    fun teamBillableInfo(): Call<TeamBillableInfoResponse>

    @POST("channels.setPurpose")
    fun channelsSetPurpose(@Header("Authorization") authorization: String, @Body request: ChannelsSetPurposeRequest): Call<ChannelsSetPurposeResponse>

    @GET("im.replies")
    fun imReplies(@Query("token") token: String,
                                @Query("thread_ts") threadTs: Double? = null,
                                @Query("channel") channel: String? = null): Call<ImRepliesResponse>

    @GET("search.messages")
    fun searchMessages(@Query("token") token: String,
                                @Query("sort_dir") sortDir: String? = null,
                                @Query("query") query: String? = null,
                                @Query("sort") sort: String? = null,
                                @Query("count") count: String? = null,
                                @Query("highlight") highlight: Boolean? = null,
                                @Query("page") page: String? = null): Call<SearchMessagesResponse>

    @POST("files.comments.delete")
    fun filesCommentsDelete(@Header("Authorization") authorization: String, @Body request: FilesCommentsDeleteRequest): Call<FilesCommentsDeleteResponse>

    @GET("groups.info")
    fun groupsInfo(@Query("token") token: String,
                                @Query("include_locale") includeLocale: Boolean? = null,
                                @Query("channel") channel: String? = null): Call<GroupsInfoResponse>

    @GET("mpim.replies")
    fun mpimReplies(@Query("token") token: String,
                                @Query("thread_ts") threadTs: Double? = null,
                                @Query("channel") channel: String? = null): Call<MpimRepliesResponse>

    @POST("pins.remove")
    fun pinsRemove(@Header("Authorization") authorization: String, @Body request: PinsRemoveRequest): Call<PinsRemoveResponse>

    @GET("conversations.history")
    fun conversationsHistory(@Query("token") token: String,
                                @Query("inclusive") inclusive: Boolean? = null,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ConversationsHistoryResponse>

    @POST("reminders.add")
    fun remindersAdd(@Header("Authorization") authorization: String, @Body request: RemindersAddRequest): Call<RemindersAddResponse>

    @POST("reactions.remove")
    fun reactionsRemove(@Header("Authorization") authorization: String, @Body request: ReactionsRemoveRequest): Call<ReactionsRemoveResponse>

    @GET("users.identity")
    fun usersIdentity(@Query("token") token: String): Call<UsersIdentityResponse>

    @GET("groups.list")
    fun groupsList(@Query("token") token: String,
                                @Query("exclude_members") excludeMembers: Boolean? = null,
                                @Query("exclude_archived") excludeArchived: Boolean? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<GroupsListResponse>

    @POST("channels.create")
    fun channelsCreate(@Header("Authorization") authorization: String, @Body request: ChannelsCreateRequest): Call<ChannelsCreateResponse>

    @POST("mpim.close")
    fun mpimClose(@Header("Authorization") authorization: String, @Body request: MpimCloseRequest): Call<MpimCloseResponse>

    @POST("users.setActive")
    fun usersSetActive(@Header("Authorization") authorization: String, @Body request: UsersSetActiveRequest): Call<UsersSetActiveResponse>

    @POST("usergroups.enable")
    fun usergroupsEnable(@Header("Authorization") authorization: String, @Body request: UsergroupsEnableRequest): Call<UsergroupsEnableResponse>

    @POST("channels.leave")
    fun channelsLeave(@Header("Authorization") authorization: String, @Body request: ChannelsLeaveRequest): Call<ChannelsLeaveResponse>

    @POST("admin.users.session.reset")
    fun adminUsersSessionReset(@Header("Authorization") authorization: String, @Body request: AdminUsersSessionResetRequest): Call<AdminUsersSessionResetResponse>

    @GET("reactions.get")
    fun reactionsGet(@Query("token") token: String,
                                @Query("full") full: Boolean? = null,
                                @Query("file_comment") fileComment: String? = null,
                                @Query("timestamp") timestamp: Double? = null,
                                @Query("file") file: String? = null,
                                @Query("channel") channel: String? = null): Call<ReactionsGetResponse>

    @POST("conversations.invite")
    fun conversationsInvite(@Header("Authorization") authorization: String, @Body request: ConversationsInviteRequest): Call<ConversationsInviteResponse>

    @POST("groups.mark")
    fun groupsMark(@Header("Authorization") authorization: String, @Body request: GroupsMarkRequest): Call<GroupsMarkResponse>

    @POST("conversations.create")
    fun conversationsCreate(@Header("Authorization") authorization: String, @Body request: ConversationsCreateRequest): Call<ConversationsCreateResponse>

    @POST("groups.setPurpose")
    fun groupsSetPurpose(@Header("Authorization") authorization: String, @Body request: GroupsSetPurposeRequest): Call<GroupsSetPurposeResponse>

    @GET("api.test")
    fun apiTest(@Query("foo") foo: String? = null,
                                @Query("error") error: String? = null): Call<ApiTestResponse>

    @GET("chat.getPermalink")
    fun chatGetPermalink(@Query("token") token: String,
                                @Query("message_ts") messageTs: Double? = null,
                                @Query("channel") channel: String? = null): Call<ChatGetPermalinkResponse>

    @GET("apps.permissions.scopes.list")
    fun appsPermissionsScopesList(@Query("token") token: String): Call<AppsPermissionsScopesListResponse>

    @GET("users.list")
    fun usersList(@Query("token") token: String,
                                @Query("include_locale") includeLocale: Boolean? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<UsersListResponse>

    @GET("dnd.teamInfo")
    fun dndTeamInfo(@Query("token") token: String,
                                @Query("users") users: String? = null): Call<DndTeamInfoResponse>

    @POST("chat.postEphemeral")
    fun chatPostEphemeral(@Header("Authorization") authorization: String, @Body request: ChatPostEphemeralRequest): Call<ChatPostEphemeralResponse>

    @GET("groups.history")
    fun groupsHistory(@Query("token") token: String,
                                @Query("count") count: Long? = null,
                                @Query("unreads") unreads: Boolean? = null,
                                @Query("inclusive") inclusive: Boolean? = null,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null): Call<GroupsHistoryResponse>

    @GET("im.list")
    fun imList(@Query("token") token: String,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ImListResponse>

    @GET("mpim.list")
    fun mpimList(@Query("token") token: String,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<MpimListResponse>

    @POST("chat.meMessage")
    fun chatMeMessage(@Header("Authorization") authorization: String, @Body request: ChatMeMessageRequest): Call<ChatMeMessageResponse>

    @POST("channels.join")
    fun channelsJoin(@Header("Authorization") authorization: String, @Body request: ChannelsJoinRequest): Call<ChannelsJoinResponse>

    @GET("conversations.info")
    fun conversationsInfo(@Query("token") token: String,
                                @Query("include_num_members") includeNumMembers: Boolean? = null,
                                @Query("channel") channel: String? = null,
                                @Query("include_locale") includeLocale: Boolean? = null): Call<ConversationsInfoResponse>

    @POST("usergroups.update")
    fun usergroupsUpdate(@Header("Authorization") authorization: String, @Body request: UsergroupsUpdateRequest): Call<UsergroupsUpdateResponse>

    @POST("dnd.endSnooze")
    fun dndEndSnooze(@Header("Authorization") authorization: String, @Body request: DndEndSnoozeRequest): Call<DndEndSnoozeResponse>

    @POST("groups.create")
    fun groupsCreate(@Header("Authorization") authorization: String, @Body request: GroupsCreateRequest): Call<GroupsCreateResponse>

    @POST("channels.rename")
    fun channelsRename(@Header("Authorization") authorization: String, @Body request: ChannelsRenameRequest): Call<ChannelsRenameResponse>

    @POST("chat.update")
    fun chatUpdate(@Header("Authorization") authorization: String, @Body request: ChatUpdateRequest): Call<ChatUpdateResponse>

    @POST("files.revokePublicURL")
    fun filesRevokePublicURL(@Header("Authorization") authorization: String, @Body request: FilesRevokePublicURLRequest): Call<FilesRevokePublicURLResponse>

    @POST("conversations.unarchive")
    fun conversationsUnarchive(@Header("Authorization") authorization: String, @Body request: ConversationsUnarchiveRequest): Call<ConversationsUnarchiveResponse>

    @GET("team.profile.get")
    fun teamProfileGet(@Query("token") token: String,
                                @Query("visibility") visibility: String? = null): Call<TeamProfileGetResponse>

    @GET("conversations.list")
    fun conversationsList(@Query("token") token: String,
                                @Query("exclude_archived") excludeArchived: Boolean? = null,
                                @Query("types") types: String? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ConversationsListResponse>

    @POST("usergroups.create")
    fun usergroupsCreate(@Header("Authorization") authorization: String, @Body request: UsergroupsCreateRequest): Call<UsergroupsCreateResponse>

    @GET("channels.history")
    fun channelsHistory(@Query("token") token: String,
                                @Query("count") count: Long? = null,
                                @Query("unreads") unreads: Boolean? = null,
                                @Query("inclusive") inclusive: Boolean? = null,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null): Call<ChannelsHistoryResponse>

    @GET("stars.list")
    fun starsList(@Query("token") token: String,
                                @Query("count") count: String? = null,
                                @Query("page") page: String? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<StarsListResponse>

    @POST("groups.invite")
    fun groupsInvite(@Header("Authorization") authorization: String, @Body request: GroupsInviteRequest): Call<GroupsInviteResponse>

    @POST("groups.archive")
    fun groupsArchive(@Header("Authorization") authorization: String, @Body request: GroupsArchiveRequest): Call<GroupsArchiveResponse>

    @GET("usergroups.list")
    fun usergroupsList(@Query("token") token: String,
                                @Query("include_users") includeUsers: Boolean? = null,
                                @Query("include_count") includeCount: Boolean? = null,
                                @Query("include_disabled") includeDisabled: Boolean? = null): Call<UsergroupsListResponse>

    @POST("users.setPresence")
    fun usersSetPresence(@Header("Authorization") authorization: String, @Body request: UsersSetPresenceRequest): Call<UsersSetPresenceResponse>

    @POST("files.sharedPublicURL")
    fun filesSharedPublicURL(@Header("Authorization") authorization: String, @Body request: FilesSharedPublicURLRequest): Call<FilesSharedPublicURLResponse>

    @POST("groups.leave")
    fun groupsLeave(@Header("Authorization") authorization: String, @Body request: GroupsLeaveRequest): Call<GroupsLeaveResponse>

    @POST("pins.add")
    fun pinsAdd(@Header("Authorization") authorization: String, @Body request: PinsAddRequest): Call<PinsAddResponse>

    @POST("conversations.leave")
    fun conversationsLeave(@Header("Authorization") authorization: String, @Body request: ConversationsLeaveRequest): Call<ConversationsLeaveResponse>

    @GET("users.profile.get")
    fun usersProfileGet(@Query("token") token: String,
                                @Query("include_labels") includeLabels: Boolean? = null,
                                @Query("user") user: String? = null): Call<UsersProfileGetResponse>

    @POST("channels.kick")
    fun channelsKick(@Header("Authorization") authorization: String, @Body request: ChannelsKickRequest): Call<ChannelsKickResponse>

    @POST("im.mark")
    fun imMark(@Header("Authorization") authorization: String, @Body request: ImMarkRequest): Call<ImMarkResponse>

    @POST("reactions.add")
    fun reactionsAdd(@Header("Authorization") authorization: String, @Body request: ReactionsAddRequest): Call<ReactionsAddResponse>

    @POST("dnd.setSnooze")
    fun dndSetSnooze(@Header("Authorization") authorization: String, @Body request: DndSetSnoozeRequest): Call<DndSetSnoozeResponse>

    @POST("im.close")
    fun imClose(@Header("Authorization") authorization: String, @Body request: ImCloseRequest): Call<ImCloseResponse>

    @POST("conversations.kick")
    fun conversationsKick(@Header("Authorization") authorization: String, @Body request: ConversationsKickRequest): Call<ConversationsKickResponse>

    @POST("reminders.delete")
    fun remindersDelete(@Header("Authorization") authorization: String, @Body request: RemindersDeleteRequest): Call<RemindersDeleteResponse>

    @GET("im.history")
    fun imHistory(@Query("token") token: String,
                                @Query("count") count: Long? = null,
                                @Query("unreads") unreads: Boolean? = null,
                                @Query("inclusive") inclusive: Boolean? = null,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null): Call<ImHistoryResponse>

    @POST("conversations.open")
    fun conversationsOpen(@Header("Authorization") authorization: String, @Body request: ConversationsOpenRequest): Call<ConversationsOpenResponse>

    @POST("groups.rename")
    fun groupsRename(@Header("Authorization") authorization: String, @Body request: GroupsRenameRequest): Call<GroupsRenameResponse>

    @GET("reactions.list")
    fun reactionsList(@Query("token") token: String,
                                @Query("count") count: String? = null,
                                @Query("full") full: Boolean? = null,
                                @Query("user") user: String? = null,
                                @Query("page") page: String? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ReactionsListResponse>

    @POST("mpim.open")
    fun mpimOpen(@Header("Authorization") authorization: String, @Body request: MpimOpenRequest): Call<MpimOpenResponse>

    @POST("chat.delete")
    fun chatDelete(@Header("Authorization") authorization: String, @Body request: ChatDeleteRequest): Call<ChatDeleteResponse>

    @GET("rtm.connect")
    fun rtmConnect(@Query("token") token: String,
                                @Query("presence_sub") presenceSub: Boolean? = null,
                                @Query("batch_presence_aware") batchPresenceAware: Boolean? = null): Call<RtmConnectResponse>

    @GET("oauth.token")
    fun oauthToken(@Query("client_secret") clientSecret: String? = null,
                                @Query("code") code: String? = null,
                                @Query("single_channel") singleChannel: Boolean? = null,
                                @Query("client_id") clientId: String? = null,
                                @Query("redirect_uri") redirectUri: String? = null): Call<OauthTokenResponse>

    @GET("apps.permissions.users.list")
    fun appsPermissionsUsersList(@Query("token") token: String,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<AppsPermissionsUsersListResponse>

    @GET("conversations.replies")
    fun conversationsReplies(@Query("token") token: String,
                                @Query("inclusive") inclusive: Boolean? = null,
                                @Query("ts") ts: Double? = null,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<ConversationsRepliesResponse>

    @GET("reminders.list")
    fun remindersList(@Query("token") token: String): Call<RemindersListResponse>

    @POST("usergroups.users.update")
    fun usergroupsUsersUpdate(@Header("Authorization") authorization: String, @Body request: UsergroupsUsersUpdateRequest): Call<UsergroupsUsersUpdateResponse>

    @GET("users.info")
    fun usersInfo(@Query("token") token: String,
                                @Query("user") user: String? = null,
                                @Query("include_locale") includeLocale: Boolean? = null): Call<UsersInfoResponse>

    @GET("dnd.info")
    fun dndInfo(@Query("token") token: String,
                                @Query("user") user: String? = null): Call<DndInfoResponse>

    @POST("reminders.complete")
    fun remindersComplete(@Header("Authorization") authorization: String, @Body request: RemindersCompleteRequest): Call<RemindersCompleteResponse>

    @GET("mpim.history")
    fun mpimHistory(@Query("token") token: String,
                                @Query("count") count: Long? = null,
                                @Query("unreads") unreads: Boolean? = null,
                                @Query("inclusive") inclusive: Boolean? = null,
                                @Query("oldest") oldest: Double? = null,
                                @Query("channel") channel: String? = null,
                                @Query("latest") latest: Double? = null): Call<MpimHistoryResponse>

    @GET("usergroups.users.list")
    fun usergroupsUsersList(): Call<UsergroupsUsersListResponse>

    @GET("reminders.info")
    fun remindersInfo(@Query("token") token: String,
                                @Query("reminder") reminder: String? = null): Call<RemindersInfoResponse>

    @POST("channels.archive")
    fun channelsArchive(@Header("Authorization") authorization: String, @Body request: ChannelsArchiveRequest): Call<ChannelsArchiveResponse>

    @POST("channels.setTopic")
    fun channelsSetTopic(@Header("Authorization") authorization: String, @Body request: ChannelsSetTopicRequest): Call<ChannelsSetTopicResponse>

    @GET("migration.exchange")
    fun migrationExchange(): Call<MigrationExchangeResponse>

    @GET("dialog.open")
    fun dialogOpen(): Call<DialogOpenResponse>

    @GET("users.getPresence")
    fun usersGetPresence(@Query("token") token: String,
                                @Query("user") user: String? = null): Call<UsersGetPresenceResponse>

    @GET("apps.permissions.resources.list")
    fun appsPermissionsResourcesList(@Query("token") token: String,
                                @Query("cursor") cursor: String? = null,
                                @Query("limit") limit: Long? = null): Call<AppsPermissionsResourcesListResponse>

    @POST("conversations.setPurpose")
    fun conversationsSetPurpose(@Header("Authorization") authorization: String, @Body request: ConversationsSetPurposeRequest): Call<ConversationsSetPurposeResponse>

    @POST("stars.remove")
    fun starsRemove(@Header("Authorization") authorization: String, @Body request: StarsRemoveRequest): Call<StarsRemoveResponse>

    @POST("dnd.endDnd")
    fun dndEndDnd(@Header("Authorization") authorization: String, @Body request: DndEndDndRequest): Call<DndEndDndResponse>

    @GET("users.lookupByEmail")
    fun usersLookupByEmail(@Query("token") token: String,
                                @Query("email") email: String? = null): Call<UsersLookupByEmailResponse>

    @POST("users.profile.set")
    fun usersProfileSet(@Header("Authorization") authorization: String, @Body request: UsersProfileSetRequest): Call<UsersProfileSetResponse>

    @GET("auth.revoke")
    fun authRevoke(@Query("token") token: String,
                                @Query("test") test: Boolean? = null): Call<AuthRevokeResponse>

}
