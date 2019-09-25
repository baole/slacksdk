package com.anttek.slack.api
import com.anttek.slack.api.request.*
import com.anttek.slack.api.response.*

class SlackApi(private val service: SlackService, private val mapper: Mapper, private var token: String = "") : BaseSlackApi() {
    fun token(token: String): SlackApi {
         this.token = token
        return this
    }

    private fun authen() = "Bearer $token"

    fun groupsOpen(request: GroupsOpenRequest): SlackResponse<GroupsOpenResponse> {
        return getResponse(service.groupsOpen(authen(), request))
    }

    fun appsPermissionsInfo(): SlackResponse<AppsPermissionsInfoResponse> {
        return getResponse(service.appsPermissionsInfo(token))
    }

    fun groupsKick(request: GroupsKickRequest): SlackResponse<GroupsKickResponse> {
        return getResponse(service.groupsKick(authen(), request))
    }

    fun chatScheduledMessagesList(oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ChatScheduledMessagesListResponse> {
        return getResponse(service.chatScheduledMessagesList(token, oldest, channel, latest, cursor, limit))
    }

    fun pinsList(channel: String? = null): SlackResponse<PinsListResponse> {
        return getResponse(service.pinsList(token, channel))
    }

    fun channelsInvite(request: ChannelsInviteRequest): SlackResponse<ChannelsInviteResponse> {
        return getResponse(service.channelsInvite(authen(), request))
    }

    fun conversationsSetTopic(request: ConversationsSetTopicRequest): SlackResponse<ConversationsSetTopicResponse> {
        return getResponse(service.conversationsSetTopic(authen(), request))
    }

    fun channelsReplies(threadTs: Double? = null,
                                channel: String? = null): SlackResponse<ChannelsRepliesResponse> {
        return getResponse(service.channelsReplies(token, threadTs, channel))
    }

    fun authTest(): SlackResponse<AuthTestResponse> {
        return getResponse(service.authTest())
    }

    fun oauthAccess(code: String? = null,
                                redirectUri: String? = null,
                                clientId: String? = null,
                                clientSecret: String? = null,
                                singleChannel: Boolean? = null): SlackResponse<OauthAccessResponse> {
        return getResponse(service.oauthAccess(code, redirectUri, clientId, clientSecret, singleChannel))
    }

    fun botsInfo(bot: String? = null): SlackResponse<BotsInfoResponse> {
        return getResponse(service.botsInfo(token, bot))
    }

    fun teamInfo(team: String? = null): SlackResponse<TeamInfoResponse> {
        return getResponse(service.teamInfo(token, team))
    }

    fun conversationsClose(request: ConversationsCloseRequest): SlackResponse<ConversationsCloseResponse> {
        return getResponse(service.conversationsClose(authen(), request))
    }

    fun groupsReplies(threadTs: Double? = null,
                                channel: String? = null): SlackResponse<GroupsRepliesResponse> {
        return getResponse(service.groupsReplies(token, threadTs, channel))
    }

    fun channelsInfo(includeLocale: Boolean? = null,
                                channel: String? = null): SlackResponse<ChannelsInfoResponse> {
        return getResponse(service.channelsInfo(token, includeLocale, channel))
    }

    fun conversationsRename(request: ConversationsRenameRequest): SlackResponse<ConversationsRenameResponse> {
        return getResponse(service.conversationsRename(authen(), request))
    }

    fun groupsUnarchive(request: GroupsUnarchiveRequest): SlackResponse<GroupsUnarchiveResponse> {
        return getResponse(service.groupsUnarchive(authen(), request))
    }

    fun filesInfo(count: String? = null,
                                file: String? = null,
                                page: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<FilesInfoResponse> {
        return getResponse(service.filesInfo(token, count, file, page, cursor, limit))
    }

    fun conversationsArchive(request: ConversationsArchiveRequest): SlackResponse<ConversationsArchiveResponse> {
        return getResponse(service.conversationsArchive(authen(), request))
    }

    fun teamIntegrationLogs(count: String? = null,
                                changeType: String? = null,
                                appId: Long? = null,
                                user: String? = null,
                                serviceId: Long? = null,
                                page: String? = null): SlackResponse<TeamIntegrationLogsResponse> {
        return getResponse(service.teamIntegrationLogs(token, count, changeType, appId, user, serviceId, page))
    }

    fun conversationsJoin(request: ConversationsJoinRequest): SlackResponse<ConversationsJoinResponse> {
        return getResponse(service.conversationsJoin(authen(), request))
    }

    fun filesUpload(request: FilesUploadRequest): SlackResponse<FilesUploadResponse> {
        return getResponse(service.filesUpload(authen(), request))
    }

    fun groupsCreateChild(request: GroupsCreateChildRequest): SlackResponse<GroupsCreateChildResponse> {
        return getResponse(service.groupsCreateChild(authen(), request))
    }

    fun channelsList(excludeMembers: Boolean? = null,
                                excludeArchived: Boolean? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ChannelsListResponse> {
        return getResponse(service.channelsList(token, excludeMembers, excludeArchived, cursor, limit))
    }

    fun conversationsMembers(channel: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsMembersResponse> {
        return getResponse(service.conversationsMembers(token, channel, cursor, limit))
    }

    fun starsAdd(request: StarsAddRequest): SlackResponse<StarsAddResponse> {
        return getResponse(service.starsAdd(authen(), request))
    }

    fun chatScheduleMessage(request: ChatScheduleMessageRequest): SlackResponse<ChatScheduleMessageResponse> {
        return getResponse(service.chatScheduleMessage(authen(), request))
    }

    fun chatUnfurl(request: ChatUnfurlRequest): SlackResponse<ChatUnfurlResponse> {
        return getResponse(service.chatUnfurl(authen(), request))
    }

    fun appsPermissionsRequest(scopes: String? = null,
                                triggerId: String? = null): SlackResponse<AppsPermissionsRequestResponse> {
        return getResponse(service.appsPermissionsRequest(token, scopes, triggerId))
    }

    fun filesList(count: String? = null,
                                channel: String? = null,
                                tsTo: Double? = null,
                                tsFrom: Double? = null,
                                user: String? = null,
                                page: String? = null,
                                types: String? = null): SlackResponse<FilesListResponse> {
        return getResponse(service.filesList(token, count, channel, tsTo, tsFrom, user, page, types))
    }

    fun filesDelete(request: FilesDeleteRequest): SlackResponse<FilesDeleteResponse> {
        return getResponse(service.filesDelete(authen(), request))
    }

    fun chatDeleteScheduledMessage(request: ChatDeleteScheduledMessageRequest): SlackResponse<ChatDeleteScheduledMessageResponse> {
        return getResponse(service.chatDeleteScheduledMessage(authen(), request))
    }

    fun chatPostMessage(request: ChatPostMessageRequest): SlackResponse<ChatPostMessageResponse> {
        return getResponse(service.chatPostMessage(authen(), request))
    }

    fun channelsMark(request: ChannelsMarkRequest): SlackResponse<ChannelsMarkResponse> {
        return getResponse(service.channelsMark(authen(), request))
    }

    fun usersConversations(user: String? = null,
                                excludeArchived: Boolean? = null,
                                types: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<UsersConversationsResponse> {
        return getResponse(service.usersConversations(token, user, excludeArchived, types, cursor, limit))
    }

    fun usersDeletePhoto(request: UsersDeletePhotoRequest): SlackResponse<UsersDeletePhotoResponse> {
        return getResponse(service.usersDeletePhoto(authen(), request))
    }

    fun usersSetPhoto(request: UsersSetPhotoRequest): SlackResponse<UsersSetPhotoResponse> {
        return getResponse(service.usersSetPhoto(authen(), request))
    }

    fun imOpen(request: ImOpenRequest): SlackResponse<ImOpenResponse> {
        return getResponse(service.imOpen(authen(), request))
    }

    fun mpimMark(request: MpimMarkRequest): SlackResponse<MpimMarkResponse> {
        return getResponse(service.mpimMark(authen(), request))
    }

    fun channelsUnarchive(request: ChannelsUnarchiveRequest): SlackResponse<ChannelsUnarchiveResponse> {
        return getResponse(service.channelsUnarchive(authen(), request))
    }

    fun appsPermissionsUsersRequest(scopes: String? = null,
                                user: String? = null,
                                triggerId: String? = null): SlackResponse<AppsPermissionsUsersRequestResponse> {
        return getResponse(service.appsPermissionsUsersRequest(token, scopes, user, triggerId))
    }

    fun emojiList(): SlackResponse<EmojiListResponse> {
        return getResponse(service.emojiList(token))
    }

    fun usergroupsDisable(request: UsergroupsDisableRequest): SlackResponse<UsergroupsDisableResponse> {
        return getResponse(service.usergroupsDisable(authen(), request))
    }

    fun appsUninstall(clientSecret: String? = null,
                                clientId: String? = null): SlackResponse<AppsUninstallResponse> {
        return getResponse(service.appsUninstall(token, clientSecret, clientId))
    }

    fun teamAccessLogs(count: String? = null,
                                page: String? = null,
                                before: Long? = null): SlackResponse<TeamAccessLogsResponse> {
        return getResponse(service.teamAccessLogs(token, count, page, before))
    }

    fun groupsSetTopic(request: GroupsSetTopicRequest): SlackResponse<GroupsSetTopicResponse> {
        return getResponse(service.groupsSetTopic(authen(), request))
    }

    fun teamBillableInfo(): SlackResponse<TeamBillableInfoResponse> {
        return getResponse(service.teamBillableInfo())
    }

    fun channelsSetPurpose(request: ChannelsSetPurposeRequest): SlackResponse<ChannelsSetPurposeResponse> {
        return getResponse(service.channelsSetPurpose(authen(), request))
    }

    fun imReplies(threadTs: Double? = null,
                                channel: String? = null): SlackResponse<ImRepliesResponse> {
        return getResponse(service.imReplies(token, threadTs, channel))
    }

    fun searchMessages(sortDir: String? = null,
                                query: String? = null,
                                sort: String? = null,
                                count: String? = null,
                                highlight: Boolean? = null,
                                page: String? = null): SlackResponse<SearchMessagesResponse> {
        return getResponse(service.searchMessages(token, sortDir, query, sort, count, highlight, page))
    }

    fun filesCommentsDelete(request: FilesCommentsDeleteRequest): SlackResponse<FilesCommentsDeleteResponse> {
        return getResponse(service.filesCommentsDelete(authen(), request))
    }

    fun groupsInfo(includeLocale: Boolean? = null,
                                channel: String? = null): SlackResponse<GroupsInfoResponse> {
        return getResponse(service.groupsInfo(token, includeLocale, channel))
    }

    fun mpimReplies(threadTs: Double? = null,
                                channel: String? = null): SlackResponse<MpimRepliesResponse> {
        return getResponse(service.mpimReplies(token, threadTs, channel))
    }

    fun pinsRemove(request: PinsRemoveRequest): SlackResponse<PinsRemoveResponse> {
        return getResponse(service.pinsRemove(authen(), request))
    }

    fun conversationsHistory(inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsHistoryResponse> {
        return getResponse(service.conversationsHistory(token, inclusive, oldest, channel, latest, cursor, limit))
    }

    fun remindersAdd(request: RemindersAddRequest): SlackResponse<RemindersAddResponse> {
        return getResponse(service.remindersAdd(authen(), request))
    }

    fun reactionsRemove(request: ReactionsRemoveRequest): SlackResponse<ReactionsRemoveResponse> {
        return getResponse(service.reactionsRemove(authen(), request))
    }

    fun usersIdentity(): SlackResponse<UsersIdentityResponse> {
        return getResponse(service.usersIdentity(token))
    }

    fun groupsList(excludeMembers: Boolean? = null,
                                excludeArchived: Boolean? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<GroupsListResponse> {
        return getResponse(service.groupsList(token, excludeMembers, excludeArchived, cursor, limit))
    }

    fun channelsCreate(request: ChannelsCreateRequest): SlackResponse<ChannelsCreateResponse> {
        return getResponse(service.channelsCreate(authen(), request))
    }

    fun mpimClose(request: MpimCloseRequest): SlackResponse<MpimCloseResponse> {
        return getResponse(service.mpimClose(authen(), request))
    }

    fun usersSetActive(request: UsersSetActiveRequest): SlackResponse<UsersSetActiveResponse> {
        return getResponse(service.usersSetActive(authen(), request))
    }

    fun usergroupsEnable(request: UsergroupsEnableRequest): SlackResponse<UsergroupsEnableResponse> {
        return getResponse(service.usergroupsEnable(authen(), request))
    }

    fun channelsLeave(request: ChannelsLeaveRequest): SlackResponse<ChannelsLeaveResponse> {
        return getResponse(service.channelsLeave(authen(), request))
    }

    fun adminUsersSessionReset(request: AdminUsersSessionResetRequest): SlackResponse<AdminUsersSessionResetResponse> {
        return getResponse(service.adminUsersSessionReset(authen(), request))
    }

    fun reactionsGet(full: Boolean? = null,
                                fileComment: String? = null,
                                timestamp: Double? = null,
                                file: String? = null,
                                channel: String? = null): SlackResponse<ReactionsGetResponse> {
        return getResponse(service.reactionsGet(token, full, fileComment, timestamp, file, channel))
    }

    fun conversationsInvite(request: ConversationsInviteRequest): SlackResponse<ConversationsInviteResponse> {
        return getResponse(service.conversationsInvite(authen(), request))
    }

    fun groupsMark(request: GroupsMarkRequest): SlackResponse<GroupsMarkResponse> {
        return getResponse(service.groupsMark(authen(), request))
    }

    fun conversationsCreate(request: ConversationsCreateRequest): SlackResponse<ConversationsCreateResponse> {
        return getResponse(service.conversationsCreate(authen(), request))
    }

    fun groupsSetPurpose(request: GroupsSetPurposeRequest): SlackResponse<GroupsSetPurposeResponse> {
        return getResponse(service.groupsSetPurpose(authen(), request))
    }

    fun apiTest(foo: String? = null,
                                error: String? = null): SlackResponse<ApiTestResponse> {
        return getResponse(service.apiTest(foo, error))
    }

    fun chatGetPermalink(messageTs: Double? = null,
                                channel: String? = null): SlackResponse<ChatGetPermalinkResponse> {
        return getResponse(service.chatGetPermalink(token, messageTs, channel))
    }

    fun appsPermissionsScopesList(): SlackResponse<AppsPermissionsScopesListResponse> {
        return getResponse(service.appsPermissionsScopesList(token))
    }

    fun usersList(includeLocale: Boolean? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<UsersListResponse> {
        return getResponse(service.usersList(token, includeLocale, cursor, limit))
    }

    fun dndTeamInfo(users: String? = null): SlackResponse<DndTeamInfoResponse> {
        return getResponse(service.dndTeamInfo(token, users))
    }

    fun chatPostEphemeral(request: ChatPostEphemeralRequest): SlackResponse<ChatPostEphemeralResponse> {
        return getResponse(service.chatPostEphemeral(authen(), request))
    }

    fun groupsHistory(count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<GroupsHistoryResponse> {
        return getResponse(service.groupsHistory(token, count, unreads, inclusive, oldest, channel, latest))
    }

    fun imList(cursor: String? = null,
                                limit: Long? = null): SlackResponse<ImListResponse> {
        return getResponse(service.imList(token, cursor, limit))
    }

    fun mpimList(cursor: String? = null,
                                limit: Long? = null): SlackResponse<MpimListResponse> {
        return getResponse(service.mpimList(token, cursor, limit))
    }

    fun chatMeMessage(request: ChatMeMessageRequest): SlackResponse<ChatMeMessageResponse> {
        return getResponse(service.chatMeMessage(authen(), request))
    }

    fun channelsJoin(request: ChannelsJoinRequest): SlackResponse<ChannelsJoinResponse> {
        return getResponse(service.channelsJoin(authen(), request))
    }

    fun conversationsInfo(includeNumMembers: Boolean? = null,
                                channel: String? = null,
                                includeLocale: Boolean? = null): SlackResponse<ConversationsInfoResponse> {
        return getResponse(service.conversationsInfo(token, includeNumMembers, channel, includeLocale))
    }

    fun usergroupsUpdate(request: UsergroupsUpdateRequest): SlackResponse<UsergroupsUpdateResponse> {
        return getResponse(service.usergroupsUpdate(authen(), request))
    }

    fun dndEndSnooze(request: DndEndSnoozeRequest): SlackResponse<DndEndSnoozeResponse> {
        return getResponse(service.dndEndSnooze(authen(), request))
    }

    fun groupsCreate(request: GroupsCreateRequest): SlackResponse<GroupsCreateResponse> {
        return getResponse(service.groupsCreate(authen(), request))
    }

    fun channelsRename(request: ChannelsRenameRequest): SlackResponse<ChannelsRenameResponse> {
        return getResponse(service.channelsRename(authen(), request))
    }

    fun chatUpdate(request: ChatUpdateRequest): SlackResponse<ChatUpdateResponse> {
        return getResponse(service.chatUpdate(authen(), request))
    }

    fun filesRevokePublicURL(request: FilesRevokePublicURLRequest): SlackResponse<FilesRevokePublicURLResponse> {
        return getResponse(service.filesRevokePublicURL(authen(), request))
    }

    fun conversationsUnarchive(request: ConversationsUnarchiveRequest): SlackResponse<ConversationsUnarchiveResponse> {
        return getResponse(service.conversationsUnarchive(authen(), request))
    }

    fun teamProfileGet(visibility: String? = null): SlackResponse<TeamProfileGetResponse> {
        return getResponse(service.teamProfileGet(token, visibility))
    }

    fun conversationsList(excludeArchived: Boolean? = null,
                                types: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsListResponse> {
        return getResponse(service.conversationsList(token, excludeArchived, types, cursor, limit))
    }

    fun usergroupsCreate(request: UsergroupsCreateRequest): SlackResponse<UsergroupsCreateResponse> {
        return getResponse(service.usergroupsCreate(authen(), request))
    }

    fun channelsHistory(count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<ChannelsHistoryResponse> {
        return getResponse(service.channelsHistory(token, count, unreads, inclusive, oldest, channel, latest))
    }

    fun starsList(count: String? = null,
                                page: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<StarsListResponse> {
        return getResponse(service.starsList(token, count, page, cursor, limit))
    }

    fun groupsInvite(request: GroupsInviteRequest): SlackResponse<GroupsInviteResponse> {
        return getResponse(service.groupsInvite(authen(), request))
    }

    fun groupsArchive(request: GroupsArchiveRequest): SlackResponse<GroupsArchiveResponse> {
        return getResponse(service.groupsArchive(authen(), request))
    }

    fun usergroupsList(includeUsers: Boolean? = null,
                                includeCount: Boolean? = null,
                                includeDisabled: Boolean? = null): SlackResponse<UsergroupsListResponse> {
        return getResponse(service.usergroupsList(token, includeUsers, includeCount, includeDisabled))
    }

    fun usersSetPresence(request: UsersSetPresenceRequest): SlackResponse<UsersSetPresenceResponse> {
        return getResponse(service.usersSetPresence(authen(), request))
    }

    fun filesSharedPublicURL(request: FilesSharedPublicURLRequest): SlackResponse<FilesSharedPublicURLResponse> {
        return getResponse(service.filesSharedPublicURL(authen(), request))
    }

    fun groupsLeave(request: GroupsLeaveRequest): SlackResponse<GroupsLeaveResponse> {
        return getResponse(service.groupsLeave(authen(), request))
    }

    fun pinsAdd(request: PinsAddRequest): SlackResponse<PinsAddResponse> {
        return getResponse(service.pinsAdd(authen(), request))
    }

    fun conversationsLeave(request: ConversationsLeaveRequest): SlackResponse<ConversationsLeaveResponse> {
        return getResponse(service.conversationsLeave(authen(), request))
    }

    fun usersProfileGet(includeLabels: Boolean? = null,
                                user: String? = null): SlackResponse<UsersProfileGetResponse> {
        return getResponse(service.usersProfileGet(token, includeLabels, user))
    }

    fun channelsKick(request: ChannelsKickRequest): SlackResponse<ChannelsKickResponse> {
        return getResponse(service.channelsKick(authen(), request))
    }

    fun imMark(request: ImMarkRequest): SlackResponse<ImMarkResponse> {
        return getResponse(service.imMark(authen(), request))
    }

    fun reactionsAdd(request: ReactionsAddRequest): SlackResponse<ReactionsAddResponse> {
        return getResponse(service.reactionsAdd(authen(), request))
    }

    fun dndSetSnooze(request: DndSetSnoozeRequest): SlackResponse<DndSetSnoozeResponse> {
        return getResponse(service.dndSetSnooze(authen(), request))
    }

    fun imClose(request: ImCloseRequest): SlackResponse<ImCloseResponse> {
        return getResponse(service.imClose(authen(), request))
    }

    fun conversationsKick(request: ConversationsKickRequest): SlackResponse<ConversationsKickResponse> {
        return getResponse(service.conversationsKick(authen(), request))
    }

    fun remindersDelete(request: RemindersDeleteRequest): SlackResponse<RemindersDeleteResponse> {
        return getResponse(service.remindersDelete(authen(), request))
    }

    fun imHistory(count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<ImHistoryResponse> {
        return getResponse(service.imHistory(token, count, unreads, inclusive, oldest, channel, latest))
    }

    fun conversationsOpen(request: ConversationsOpenRequest): SlackResponse<ConversationsOpenResponse> {
        return getResponse(service.conversationsOpen(authen(), request))
    }

    fun groupsRename(request: GroupsRenameRequest): SlackResponse<GroupsRenameResponse> {
        return getResponse(service.groupsRename(authen(), request))
    }

    fun reactionsList(count: String? = null,
                                full: Boolean? = null,
                                user: String? = null,
                                page: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ReactionsListResponse> {
        return getResponse(service.reactionsList(token, count, full, user, page, cursor, limit))
    }

    fun mpimOpen(request: MpimOpenRequest): SlackResponse<MpimOpenResponse> {
        return getResponse(service.mpimOpen(authen(), request))
    }

    fun chatDelete(request: ChatDeleteRequest): SlackResponse<ChatDeleteResponse> {
        return getResponse(service.chatDelete(authen(), request))
    }

    fun rtmConnect(presenceSub: Boolean? = null,
                                batchPresenceAware: Boolean? = null): SlackResponse<RtmConnectResponse> {
        return getResponse(service.rtmConnect(token, presenceSub, batchPresenceAware))
    }

    fun oauthToken(clientSecret: String? = null,
                                code: String? = null,
                                singleChannel: Boolean? = null,
                                clientId: String? = null,
                                redirectUri: String? = null): SlackResponse<OauthTokenResponse> {
        return getResponse(service.oauthToken(clientSecret, code, singleChannel, clientId, redirectUri))
    }

    fun appsPermissionsUsersList(cursor: String? = null,
                                limit: Long? = null): SlackResponse<AppsPermissionsUsersListResponse> {
        return getResponse(service.appsPermissionsUsersList(token, cursor, limit))
    }

    fun conversationsReplies(inclusive: Boolean? = null,
                                ts: Double? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsRepliesResponse> {
        return getResponse(service.conversationsReplies(token, inclusive, ts, oldest, channel, latest, cursor, limit))
    }

    fun remindersList(): SlackResponse<RemindersListResponse> {
        return getResponse(service.remindersList(token))
    }

    fun usergroupsUsersUpdate(request: UsergroupsUsersUpdateRequest): SlackResponse<UsergroupsUsersUpdateResponse> {
        return getResponse(service.usergroupsUsersUpdate(authen(), request))
    }

    fun usersInfo(user: String? = null,
                                includeLocale: Boolean? = null): SlackResponse<UsersInfoResponse> {
        return getResponse(service.usersInfo(token, user, includeLocale))
    }

    fun dndInfo(user: String? = null): SlackResponse<DndInfoResponse> {
        return getResponse(service.dndInfo(token, user))
    }

    fun remindersComplete(request: RemindersCompleteRequest): SlackResponse<RemindersCompleteResponse> {
        return getResponse(service.remindersComplete(authen(), request))
    }

    fun mpimHistory(count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<MpimHistoryResponse> {
        return getResponse(service.mpimHistory(token, count, unreads, inclusive, oldest, channel, latest))
    }

    fun usergroupsUsersList(): SlackResponse<UsergroupsUsersListResponse> {
        return getResponse(service.usergroupsUsersList())
    }

    fun remindersInfo(reminder: String? = null): SlackResponse<RemindersInfoResponse> {
        return getResponse(service.remindersInfo(token, reminder))
    }

    fun channelsArchive(request: ChannelsArchiveRequest): SlackResponse<ChannelsArchiveResponse> {
        return getResponse(service.channelsArchive(authen(), request))
    }

    fun channelsSetTopic(request: ChannelsSetTopicRequest): SlackResponse<ChannelsSetTopicResponse> {
        return getResponse(service.channelsSetTopic(authen(), request))
    }

    fun migrationExchange(): SlackResponse<MigrationExchangeResponse> {
        return getResponse(service.migrationExchange())
    }

    fun dialogOpen(): SlackResponse<DialogOpenResponse> {
        return getResponse(service.dialogOpen())
    }

    fun usersGetPresence(user: String? = null): SlackResponse<UsersGetPresenceResponse> {
        return getResponse(service.usersGetPresence(token, user))
    }

    fun appsPermissionsResourcesList(cursor: String? = null,
                                limit: Long? = null): SlackResponse<AppsPermissionsResourcesListResponse> {
        return getResponse(service.appsPermissionsResourcesList(token, cursor, limit))
    }

    fun conversationsSetPurpose(request: ConversationsSetPurposeRequest): SlackResponse<ConversationsSetPurposeResponse> {
        return getResponse(service.conversationsSetPurpose(authen(), request))
    }

    fun starsRemove(request: StarsRemoveRequest): SlackResponse<StarsRemoveResponse> {
        return getResponse(service.starsRemove(authen(), request))
    }

    fun dndEndDnd(request: DndEndDndRequest): SlackResponse<DndEndDndResponse> {
        return getResponse(service.dndEndDnd(authen(), request))
    }

    fun usersLookupByEmail(email: String? = null): SlackResponse<UsersLookupByEmailResponse> {
        return getResponse(service.usersLookupByEmail(token, email))
    }

    fun usersProfileSet(request: UsersProfileSetRequest): SlackResponse<UsersProfileSetResponse> {
        return getResponse(service.usersProfileSet(authen(), request))
    }

    fun authRevoke(test: Boolean? = null): SlackResponse<AuthRevokeResponse> {
        return getResponse(service.authRevoke(token, test))
    }

}
