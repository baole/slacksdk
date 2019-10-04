package com.anttek.slack.api
import com.anttek.slack.api.request.*
import com.anttek.slack.api.response.*

class SlackSdk(private val service: SlackService, private val mapper: Mapper, private var token: String = "") : BaseSlackSdk() {
    fun token(token: String): SlackSdk {
         this.token = token
        return this
    }

    fun resolveGetToken(token: String?) = token ?: this.token

    fun resolvePostToken(request: GenericRequest) = "Bearer ${request.token ?: token}"

    fun groupsOpen(request: GroupsOpenRequest): SlackResponse<GenericResponse> {
        return getResponse(service.groupsOpen(resolvePostToken(request), request))
    }

    fun appsPermissionsInfo(token: String? = null): SlackResponse<AppsPermissionsInfoResponse> {
        return getResponse(service.appsPermissionsInfo(resolveGetToken(token)))
    }

    fun groupsKick(request: GroupsKickRequest): SlackResponse<GenericResponse> {
        return getResponse(service.groupsKick(resolvePostToken(request), request))
    }

    fun chatScheduledMessagesList(token: String? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ChatScheduledMessagesListResponse> {
        return getResponse(service.chatScheduledMessagesList(resolveGetToken(token), oldest, channel, latest, cursor, limit))
    }

    fun pinsList(token: String? = null,
                                channel: String? = null): SlackResponse<PinsListResponse> {
        return getResponse(service.pinsList(resolveGetToken(token), channel))
    }

    fun channelsInvite(request: ChannelsInviteRequest): SlackResponse<ChannelsInviteResponse> {
        return getResponse(service.channelsInvite(resolvePostToken(request), request))
    }

    fun conversationsSetTopic(request: ConversationsSetTopicRequest): SlackResponse<ConversationsSetTopicResponse> {
        return getResponse(service.conversationsSetTopic(resolvePostToken(request), request))
    }

    fun channelsReplies(token: String? = null,
                                threadTs: Double? = null,
                                channel: String? = null): SlackResponse<ChannelsRepliesResponse> {
        return getResponse(service.channelsReplies(resolveGetToken(token), threadTs, channel))
    }

    fun authTest(): SlackResponse<AuthTestResponse> {
        return getResponse(service.authTest())
    }

    fun oauthAccess(code: String? = null,
                                redirectUri: String? = null,
                                clientId: String? = null,
                                clientSecret: String? = null,
                                singleChannel: Boolean? = null): SlackResponse<GenericResponse> {
        return getResponse(service.oauthAccess(code, redirectUri, clientId, clientSecret, singleChannel))
    }

    fun botsInfo(token: String? = null,
                                bot: String? = null): SlackResponse<BotsInfoResponse> {
        return getResponse(service.botsInfo(resolveGetToken(token), bot))
    }

    fun teamInfo(token: String? = null,
                                team: String? = null): SlackResponse<TeamInfoResponse> {
        return getResponse(service.teamInfo(resolveGetToken(token), team))
    }

    fun conversationsClose(request: ConversationsCloseRequest): SlackResponse<ConversationsCloseResponse> {
        return getResponse(service.conversationsClose(resolvePostToken(request), request))
    }

    fun groupsReplies(token: String? = null,
                                threadTs: Double? = null,
                                channel: String? = null): SlackResponse<GroupsRepliesResponse> {
        return getResponse(service.groupsReplies(resolveGetToken(token), threadTs, channel))
    }

    fun channelsInfo(token: String? = null,
                                includeLocale: Boolean? = null,
                                channel: String? = null): SlackResponse<ChannelsInfoResponse> {
        return getResponse(service.channelsInfo(resolveGetToken(token), includeLocale, channel))
    }

    fun conversationsRename(request: ConversationsRenameRequest): SlackResponse<ConversationsRenameResponse> {
        return getResponse(service.conversationsRename(resolvePostToken(request), request))
    }

    fun groupsUnarchive(request: GroupsUnarchiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.groupsUnarchive(resolvePostToken(request), request))
    }

    fun filesInfo(token: String? = null,
                                count: String? = null,
                                file: String? = null,
                                page: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<FilesInfoResponse> {
        return getResponse(service.filesInfo(resolveGetToken(token), count, file, page, cursor, limit))
    }

    fun conversationsArchive(request: ConversationsArchiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.conversationsArchive(resolvePostToken(request), request))
    }

    fun teamIntegrationLogs(token: String? = null,
                                count: String? = null,
                                changeType: String? = null,
                                appId: Long? = null,
                                user: String? = null,
                                serviceId: Long? = null,
                                page: String? = null): SlackResponse<TeamIntegrationLogsResponse> {
        return getResponse(service.teamIntegrationLogs(resolveGetToken(token), count, changeType, appId, user, serviceId, page))
    }

    fun conversationsJoin(request: ConversationsJoinRequest): SlackResponse<ConversationsJoinResponse> {
        return getResponse(service.conversationsJoin(resolvePostToken(request), request))
    }

    fun filesUpload(request: FilesUploadRequest): SlackResponse<FilesUploadResponse> {
        return getResponse(service.filesUpload(resolvePostToken(request), request))
    }

    fun groupsCreateChild(request: GroupsCreateChildRequest): SlackResponse<GroupsCreateChildResponse> {
        return getResponse(service.groupsCreateChild(resolvePostToken(request), request))
    }

    fun channelsList(token: String? = null,
                                excludeMembers: Boolean? = null,
                                excludeArchived: Boolean? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ChannelsListResponse> {
        return getResponse(service.channelsList(resolveGetToken(token), excludeMembers, excludeArchived, cursor, limit))
    }

    fun conversationsMembers(token: String? = null,
                                channel: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsMembersResponse> {
        return getResponse(service.conversationsMembers(resolveGetToken(token), channel, cursor, limit))
    }

    fun starsAdd(request: StarsAddRequest): SlackResponse<GenericResponse> {
        return getResponse(service.starsAdd(resolvePostToken(request), request))
    }

    fun chatScheduleMessage(request: ChatScheduleMessageRequest): SlackResponse<ChatScheduleMessageResponse> {
        return getResponse(service.chatScheduleMessage(resolvePostToken(request), request))
    }

    fun chatUnfurl(request: ChatUnfurlRequest): SlackResponse<GenericResponse> {
        return getResponse(service.chatUnfurl(resolvePostToken(request), request))
    }

    fun appsPermissionsRequest(token: String? = null,
                                scopes: String? = null,
                                triggerId: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.appsPermissionsRequest(resolveGetToken(token), scopes, triggerId))
    }

    fun filesList(token: String? = null,
                                count: String? = null,
                                channel: String? = null,
                                tsTo: Double? = null,
                                tsFrom: Double? = null,
                                user: String? = null,
                                page: String? = null,
                                types: String? = null): SlackResponse<FilesListResponse> {
        return getResponse(service.filesList(resolveGetToken(token), count, channel, tsTo, tsFrom, user, page, types))
    }

    fun filesDelete(request: FilesDeleteRequest): SlackResponse<GenericResponse> {
        return getResponse(service.filesDelete(resolvePostToken(request), request))
    }

    fun chatDeleteScheduledMessage(request: ChatDeleteScheduledMessageRequest): SlackResponse<GenericResponse> {
        return getResponse(service.chatDeleteScheduledMessage(resolvePostToken(request), request))
    }

    fun chatPostMessage(request: ChatPostMessageRequest): SlackResponse<ChatPostMessageResponse> {
        return getResponse(service.chatPostMessage(resolvePostToken(request), request))
    }

    fun channelsMark(request: ChannelsMarkRequest): SlackResponse<GenericResponse> {
        return getResponse(service.channelsMark(resolvePostToken(request), request))
    }

    fun usersConversations(token: String? = null,
                                user: String? = null,
                                excludeArchived: Boolean? = null,
                                types: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<UsersConversationsResponse> {
        return getResponse(service.usersConversations(resolveGetToken(token), user, excludeArchived, types, cursor, limit))
    }

    fun usersDeletePhoto(request: UsersDeletePhotoRequest): SlackResponse<GenericResponse> {
        return getResponse(service.usersDeletePhoto(resolvePostToken(request), request))
    }

    fun usersSetPhoto(request: UsersSetPhotoRequest): SlackResponse<UsersSetPhotoResponse> {
        return getResponse(service.usersSetPhoto(resolvePostToken(request), request))
    }

    fun imOpen(request: ImOpenRequest): SlackResponse<ImOpenResponse> {
        return getResponse(service.imOpen(resolvePostToken(request), request))
    }

    fun mpimMark(request: MpimMarkRequest): SlackResponse<GenericResponse> {
        return getResponse(service.mpimMark(resolvePostToken(request), request))
    }

    fun channelsUnarchive(request: ChannelsUnarchiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.channelsUnarchive(resolvePostToken(request), request))
    }

    fun appsPermissionsUsersRequest(token: String? = null,
                                scopes: String? = null,
                                user: String? = null,
                                triggerId: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.appsPermissionsUsersRequest(resolveGetToken(token), scopes, user, triggerId))
    }

    fun emojiList(token: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.emojiList(resolveGetToken(token)))
    }

    fun usergroupsDisable(request: UsergroupsDisableRequest): SlackResponse<UsergroupsDisableResponse> {
        return getResponse(service.usergroupsDisable(resolvePostToken(request), request))
    }

    fun appsUninstall(token: String? = null,
                                clientSecret: String? = null,
                                clientId: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.appsUninstall(resolveGetToken(token), clientSecret, clientId))
    }

    fun teamAccessLogs(token: String? = null,
                                count: String? = null,
                                page: String? = null,
                                before: Long? = null): SlackResponse<TeamAccessLogsResponse> {
        return getResponse(service.teamAccessLogs(resolveGetToken(token), count, page, before))
    }

    fun groupsSetTopic(request: GroupsSetTopicRequest): SlackResponse<GroupsSetTopicResponse> {
        return getResponse(service.groupsSetTopic(resolvePostToken(request), request))
    }

    fun teamBillableInfo(): SlackResponse<TeamBillableInfoResponse> {
        return getResponse(service.teamBillableInfo())
    }

    fun channelsSetPurpose(request: ChannelsSetPurposeRequest): SlackResponse<ChannelsSetPurposeResponse> {
        return getResponse(service.channelsSetPurpose(resolvePostToken(request), request))
    }

    fun imReplies(token: String? = null,
                                threadTs: Double? = null,
                                channel: String? = null): SlackResponse<ImRepliesResponse> {
        return getResponse(service.imReplies(resolveGetToken(token), threadTs, channel))
    }

    fun searchMessages(token: String? = null,
                                sortDir: String? = null,
                                query: String? = null,
                                sort: String? = null,
                                count: String? = null,
                                highlight: Boolean? = null,
                                page: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.searchMessages(resolveGetToken(token), sortDir, query, sort, count, highlight, page))
    }

    fun filesCommentsDelete(request: FilesCommentsDeleteRequest): SlackResponse<GenericResponse> {
        return getResponse(service.filesCommentsDelete(resolvePostToken(request), request))
    }

    fun groupsInfo(token: String? = null,
                                includeLocale: Boolean? = null,
                                channel: String? = null): SlackResponse<GroupsInfoResponse> {
        return getResponse(service.groupsInfo(resolveGetToken(token), includeLocale, channel))
    }

    fun mpimReplies(token: String? = null,
                                threadTs: Double? = null,
                                channel: String? = null): SlackResponse<MpimRepliesResponse> {
        return getResponse(service.mpimReplies(resolveGetToken(token), threadTs, channel))
    }

    fun pinsRemove(request: PinsRemoveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.pinsRemove(resolvePostToken(request), request))
    }

    fun conversationsHistory(token: String? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsHistoryResponse> {
        return getResponse(service.conversationsHistory(resolveGetToken(token), inclusive, oldest, channel, latest, cursor, limit))
    }

    fun remindersAdd(request: RemindersAddRequest): SlackResponse<RemindersAddResponse> {
        return getResponse(service.remindersAdd(resolvePostToken(request), request))
    }

    fun reactionsRemove(request: ReactionsRemoveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.reactionsRemove(resolvePostToken(request), request))
    }

    fun usersIdentity(token: String? = null): SlackResponse<UsersIdentityResponse> {
        return getResponse(service.usersIdentity(resolveGetToken(token)))
    }

    fun groupsList(token: String? = null,
                                excludeMembers: Boolean? = null,
                                excludeArchived: Boolean? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<GroupsListResponse> {
        return getResponse(service.groupsList(resolveGetToken(token), excludeMembers, excludeArchived, cursor, limit))
    }

    fun channelsCreate(request: ChannelsCreateRequest): SlackResponse<ChannelsCreateResponse> {
        return getResponse(service.channelsCreate(resolvePostToken(request), request))
    }

    fun mpimClose(request: MpimCloseRequest): SlackResponse<GenericResponse> {
        return getResponse(service.mpimClose(resolvePostToken(request), request))
    }

    fun usersSetActive(request: UsersSetActiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.usersSetActive(resolvePostToken(request), request))
    }

    fun usergroupsEnable(request: UsergroupsEnableRequest): SlackResponse<UsergroupsEnableResponse> {
        return getResponse(service.usergroupsEnable(resolvePostToken(request), request))
    }

    fun channelsLeave(request: ChannelsLeaveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.channelsLeave(resolvePostToken(request), request))
    }

    fun adminUsersSessionReset(request: AdminUsersSessionResetRequest): SlackResponse<GenericResponse> {
        return getResponse(service.adminUsersSessionReset(resolvePostToken(request), request))
    }

    fun reactionsGet(token: String? = null,
                                full: Boolean? = null,
                                fileComment: String? = null,
                                timestamp: Double? = null,
                                file: String? = null,
                                channel: String? = null): SlackResponse<ReactionsGetResponse> {
        return getResponse(service.reactionsGet(resolveGetToken(token), full, fileComment, timestamp, file, channel))
    }

    fun conversationsInvite(request: ConversationsInviteRequest): SlackResponse<ConversationsInviteResponse> {
        return getResponse(service.conversationsInvite(resolvePostToken(request), request))
    }

    fun groupsMark(request: GroupsMarkRequest): SlackResponse<GenericResponse> {
        return getResponse(service.groupsMark(resolvePostToken(request), request))
    }

    fun conversationsCreate(request: ConversationsCreateRequest): SlackResponse<ConversationsCreateResponse> {
        return getResponse(service.conversationsCreate(resolvePostToken(request), request))
    }

    fun groupsSetPurpose(request: GroupsSetPurposeRequest): SlackResponse<GroupsSetPurposeResponse> {
        return getResponse(service.groupsSetPurpose(resolvePostToken(request), request))
    }

    fun apiTest(foo: String? = null,
                                error: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.apiTest(foo, error))
    }

    fun chatGetPermalink(token: String? = null,
                                messageTs: Double? = null,
                                channel: String? = null): SlackResponse<ChatGetPermalinkResponse> {
        return getResponse(service.chatGetPermalink(resolveGetToken(token), messageTs, channel))
    }

    fun appsPermissionsScopesList(token: String? = null): SlackResponse<AppsPermissionsScopesListResponse> {
        return getResponse(service.appsPermissionsScopesList(resolveGetToken(token)))
    }

    fun usersList(token: String? = null,
                                includeLocale: Boolean? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<UsersListResponse> {
        return getResponse(service.usersList(resolveGetToken(token), includeLocale, cursor, limit))
    }

    fun dndTeamInfo(token: String? = null,
                                users: String? = null): SlackResponse<DndTeamInfoResponse> {
        return getResponse(service.dndTeamInfo(resolveGetToken(token), users))
    }

    fun chatPostEphemeral(request: ChatPostEphemeralRequest): SlackResponse<ChatPostEphemeralResponse> {
        return getResponse(service.chatPostEphemeral(resolvePostToken(request), request))
    }

    fun groupsHistory(token: String? = null,
                                count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<GroupsHistoryResponse> {
        return getResponse(service.groupsHistory(resolveGetToken(token), count, unreads, inclusive, oldest, channel, latest))
    }

    fun imList(token: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ImListResponse> {
        return getResponse(service.imList(resolveGetToken(token), cursor, limit))
    }

    fun mpimList(token: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<MpimListResponse> {
        return getResponse(service.mpimList(resolveGetToken(token), cursor, limit))
    }

    fun chatMeMessage(request: ChatMeMessageRequest): SlackResponse<ChatMeMessageResponse> {
        return getResponse(service.chatMeMessage(resolvePostToken(request), request))
    }

    fun channelsJoin(request: ChannelsJoinRequest): SlackResponse<ChannelsJoinResponse> {
        return getResponse(service.channelsJoin(resolvePostToken(request), request))
    }

    fun conversationsInfo(token: String? = null,
                                includeNumMembers: Boolean? = null,
                                channel: String? = null,
                                includeLocale: Boolean? = null): SlackResponse<ConversationsInfoResponse> {
        return getResponse(service.conversationsInfo(resolveGetToken(token), includeNumMembers, channel, includeLocale))
    }

    fun usergroupsUpdate(request: UsergroupsUpdateRequest): SlackResponse<UsergroupsUpdateResponse> {
        return getResponse(service.usergroupsUpdate(resolvePostToken(request), request))
    }

    fun dndEndSnooze(request: DndEndSnoozeRequest): SlackResponse<DndEndSnoozeResponse> {
        return getResponse(service.dndEndSnooze(resolvePostToken(request), request))
    }

    fun groupsCreate(request: GroupsCreateRequest): SlackResponse<GroupsCreateResponse> {
        return getResponse(service.groupsCreate(resolvePostToken(request), request))
    }

    fun channelsRename(request: ChannelsRenameRequest): SlackResponse<ChannelsRenameResponse> {
        return getResponse(service.channelsRename(resolvePostToken(request), request))
    }

    fun chatUpdate(request: ChatUpdateRequest): SlackResponse<ChatUpdateResponse> {
        return getResponse(service.chatUpdate(resolvePostToken(request), request))
    }

    fun filesRevokePublicURL(request: FilesRevokePublicURLRequest): SlackResponse<FilesRevokePublicURLResponse> {
        return getResponse(service.filesRevokePublicURL(resolvePostToken(request), request))
    }

    fun conversationsUnarchive(request: ConversationsUnarchiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.conversationsUnarchive(resolvePostToken(request), request))
    }

    fun teamProfileGet(token: String? = null,
                                visibility: String? = null): SlackResponse<TeamProfileGetResponse> {
        return getResponse(service.teamProfileGet(resolveGetToken(token), visibility))
    }

    fun conversationsList(token: String? = null,
                                excludeArchived: Boolean? = null,
                                types: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsListResponse> {
        return getResponse(service.conversationsList(resolveGetToken(token), excludeArchived, types, cursor, limit))
    }

    fun usergroupsCreate(request: UsergroupsCreateRequest): SlackResponse<UsergroupsCreateResponse> {
        return getResponse(service.usergroupsCreate(resolvePostToken(request), request))
    }

    fun channelsHistory(token: String? = null,
                                count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<ChannelsHistoryResponse> {
        return getResponse(service.channelsHistory(resolveGetToken(token), count, unreads, inclusive, oldest, channel, latest))
    }

    fun starsList(token: String? = null,
                                count: String? = null,
                                page: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<StarsListResponse> {
        return getResponse(service.starsList(resolveGetToken(token), count, page, cursor, limit))
    }

    fun groupsInvite(request: GroupsInviteRequest): SlackResponse<GroupsInviteResponse> {
        return getResponse(service.groupsInvite(resolvePostToken(request), request))
    }

    fun groupsArchive(request: GroupsArchiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.groupsArchive(resolvePostToken(request), request))
    }

    fun usergroupsList(token: String? = null,
                                includeUsers: Boolean? = null,
                                includeCount: Boolean? = null,
                                includeDisabled: Boolean? = null): SlackResponse<UsergroupsListResponse> {
        return getResponse(service.usergroupsList(resolveGetToken(token), includeUsers, includeCount, includeDisabled))
    }

    fun usersSetPresence(request: UsersSetPresenceRequest): SlackResponse<GenericResponse> {
        return getResponse(service.usersSetPresence(resolvePostToken(request), request))
    }

    fun filesSharedPublicURL(request: FilesSharedPublicURLRequest): SlackResponse<FilesSharedPublicURLResponse> {
        return getResponse(service.filesSharedPublicURL(resolvePostToken(request), request))
    }

    fun groupsLeave(request: GroupsLeaveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.groupsLeave(resolvePostToken(request), request))
    }

    fun pinsAdd(request: PinsAddRequest): SlackResponse<GenericResponse> {
        return getResponse(service.pinsAdd(resolvePostToken(request), request))
    }

    fun conversationsLeave(request: ConversationsLeaveRequest): SlackResponse<ConversationsLeaveResponse> {
        return getResponse(service.conversationsLeave(resolvePostToken(request), request))
    }

    fun usersProfileGet(token: String? = null,
                                includeLabels: Boolean? = null,
                                user: String? = null): SlackResponse<UsersProfileGetResponse> {
        return getResponse(service.usersProfileGet(resolveGetToken(token), includeLabels, user))
    }

    fun channelsKick(request: ChannelsKickRequest): SlackResponse<GenericResponse> {
        return getResponse(service.channelsKick(resolvePostToken(request), request))
    }

    fun imMark(request: ImMarkRequest): SlackResponse<GenericResponse> {
        return getResponse(service.imMark(resolvePostToken(request), request))
    }

    fun reactionsAdd(request: ReactionsAddRequest): SlackResponse<GenericResponse> {
        return getResponse(service.reactionsAdd(resolvePostToken(request), request))
    }

    fun dndSetSnooze(request: DndSetSnoozeRequest): SlackResponse<DndSetSnoozeResponse> {
        return getResponse(service.dndSetSnooze(resolvePostToken(request), request))
    }

    fun imClose(request: ImCloseRequest): SlackResponse<ImCloseResponse> {
        return getResponse(service.imClose(resolvePostToken(request), request))
    }

    fun conversationsKick(request: ConversationsKickRequest): SlackResponse<GenericResponse> {
        return getResponse(service.conversationsKick(resolvePostToken(request), request))
    }

    fun remindersDelete(request: RemindersDeleteRequest): SlackResponse<GenericResponse> {
        return getResponse(service.remindersDelete(resolvePostToken(request), request))
    }

    fun imHistory(token: String? = null,
                                count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<ImHistoryResponse> {
        return getResponse(service.imHistory(resolveGetToken(token), count, unreads, inclusive, oldest, channel, latest))
    }

    fun conversationsOpen(request: ConversationsOpenRequest): SlackResponse<ConversationsOpenResponse> {
        return getResponse(service.conversationsOpen(resolvePostToken(request), request))
    }

    fun groupsRename(request: GroupsRenameRequest): SlackResponse<GroupsRenameResponse> {
        return getResponse(service.groupsRename(resolvePostToken(request), request))
    }

    fun reactionsList(token: String? = null,
                                count: String? = null,
                                full: Boolean? = null,
                                user: String? = null,
                                page: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ReactionsListResponse> {
        return getResponse(service.reactionsList(resolveGetToken(token), count, full, user, page, cursor, limit))
    }

    fun mpimOpen(request: MpimOpenRequest): SlackResponse<MpimOpenResponse> {
        return getResponse(service.mpimOpen(resolvePostToken(request), request))
    }

    fun chatDelete(request: ChatDeleteRequest): SlackResponse<ChatDeleteResponse> {
        return getResponse(service.chatDelete(resolvePostToken(request), request))
    }

    fun rtmConnect(token: String? = null,
                                presenceSub: Boolean? = null,
                                batchPresenceAware: Boolean? = null): SlackResponse<RtmConnectResponse> {
        return getResponse(service.rtmConnect(resolveGetToken(token), presenceSub, batchPresenceAware))
    }

    fun oauthToken(clientSecret: String? = null,
                                code: String? = null,
                                singleChannel: Boolean? = null,
                                clientId: String? = null,
                                redirectUri: String? = null): SlackResponse<GenericResponse> {
        return getResponse(service.oauthToken(clientSecret, code, singleChannel, clientId, redirectUri))
    }

    fun appsPermissionsUsersList(token: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<GenericResponse> {
        return getResponse(service.appsPermissionsUsersList(resolveGetToken(token), cursor, limit))
    }

    fun conversationsReplies(token: String? = null,
                                inclusive: Boolean? = null,
                                ts: Double? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<ConversationsRepliesResponse> {
        return getResponse(service.conversationsReplies(resolveGetToken(token), inclusive, ts, oldest, channel, latest, cursor, limit))
    }

    fun remindersList(token: String? = null): SlackResponse<RemindersListResponse> {
        return getResponse(service.remindersList(resolveGetToken(token)))
    }

    fun usergroupsUsersUpdate(request: UsergroupsUsersUpdateRequest): SlackResponse<UsergroupsUsersUpdateResponse> {
        return getResponse(service.usergroupsUsersUpdate(resolvePostToken(request), request))
    }

    fun usersInfo(token: String? = null,
                                user: String? = null,
                                includeLocale: Boolean? = null): SlackResponse<UsersInfoResponse> {
        return getResponse(service.usersInfo(resolveGetToken(token), user, includeLocale))
    }

    fun dndInfo(token: String? = null,
                                user: String? = null): SlackResponse<DndInfoResponse> {
        return getResponse(service.dndInfo(resolveGetToken(token), user))
    }

    fun remindersComplete(request: RemindersCompleteRequest): SlackResponse<GenericResponse> {
        return getResponse(service.remindersComplete(resolvePostToken(request), request))
    }

    fun mpimHistory(token: String? = null,
                                count: Long? = null,
                                unreads: Boolean? = null,
                                inclusive: Boolean? = null,
                                oldest: Double? = null,
                                channel: String? = null,
                                latest: Double? = null): SlackResponse<MpimHistoryResponse> {
        return getResponse(service.mpimHistory(resolveGetToken(token), count, unreads, inclusive, oldest, channel, latest))
    }

    fun usergroupsUsersList(): SlackResponse<UsergroupsUsersListResponse> {
        return getResponse(service.usergroupsUsersList())
    }

    fun remindersInfo(token: String? = null,
                                reminder: String? = null): SlackResponse<RemindersInfoResponse> {
        return getResponse(service.remindersInfo(resolveGetToken(token), reminder))
    }

    fun channelsArchive(request: ChannelsArchiveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.channelsArchive(resolvePostToken(request), request))
    }

    fun channelsSetTopic(request: ChannelsSetTopicRequest): SlackResponse<ChannelsSetTopicResponse> {
        return getResponse(service.channelsSetTopic(resolvePostToken(request), request))
    }

    fun migrationExchange(): SlackResponse<MigrationExchangeResponse> {
        return getResponse(service.migrationExchange())
    }

    fun dialogOpen(): SlackResponse<GenericResponse> {
        return getResponse(service.dialogOpen())
    }

    fun usersGetPresence(token: String? = null,
                                user: String? = null): SlackResponse<UsersGetPresenceResponse> {
        return getResponse(service.usersGetPresence(resolveGetToken(token), user))
    }

    fun appsPermissionsResourcesList(token: String? = null,
                                cursor: String? = null,
                                limit: Long? = null): SlackResponse<AppsPermissionsResourcesListResponse> {
        return getResponse(service.appsPermissionsResourcesList(resolveGetToken(token), cursor, limit))
    }

    fun conversationsSetPurpose(request: ConversationsSetPurposeRequest): SlackResponse<ConversationsSetPurposeResponse> {
        return getResponse(service.conversationsSetPurpose(resolvePostToken(request), request))
    }

    fun starsRemove(request: StarsRemoveRequest): SlackResponse<GenericResponse> {
        return getResponse(service.starsRemove(resolvePostToken(request), request))
    }

    fun dndEndDnd(request: DndEndDndRequest): SlackResponse<GenericResponse> {
        return getResponse(service.dndEndDnd(resolvePostToken(request), request))
    }

    fun usersLookupByEmail(token: String? = null,
                                email: String? = null): SlackResponse<UsersLookupByEmailResponse> {
        return getResponse(service.usersLookupByEmail(resolveGetToken(token), email))
    }

    fun usersProfileSet(request: UsersProfileSetRequest): SlackResponse<UsersProfileSetResponse> {
        return getResponse(service.usersProfileSet(resolvePostToken(request), request))
    }

    fun authRevoke(token: String? = null,
                                test: Boolean? = null): SlackResponse<AuthRevokeResponse> {
        return getResponse(service.authRevoke(resolveGetToken(token), test))
    }

}
