package com.anttek.slack.api.model

import com.fasterxml.jackson.annotation.JsonProperty

class UserProfile() {
    var image32: String? = null
    var statusEmoji: String? = null
    var guestInvitedBy: String? = null
    var apiAppId: String? = null
    @JsonProperty(value = "image_192")
    var image192: String? = null
    @JsonProperty(value = "real_name")
    var realName: String? = null
    var title: String? = null
    var statusTextCanonical: String? = null
    var skype: String? = null
    var imageOriginal: String? = null
    var guestChannels: String? = null
    var guestExpirationTs: Long? = null
    var realNameNormalized: String? = null
    var avatarHash: String? = null
    @JsonProperty(value = "first_name")
    var firstName: String? = null
    var botId: String? = null
    var email: String? = null
    @JsonProperty(value = "image_512")
    var image512: String? = null
    @JsonProperty(value = "image_1024")
    var image1024: String? = null
    var teams: String? = null
    @JsonProperty(value = "image_24")
    var image24: String? = null
    @JsonProperty(value = "last_name")
    var lastName: String? = null
    @JsonProperty(value = "image_48")
    var image48: String? = null
    var team: String? = null
    @JsonProperty(value = "display_name")
    var displayName: String? = null
    var alwaysActive: Boolean? = null
    var statusExpiration: Long? = null
    var phone: String? = null
    var isCustomImage: Boolean? = null
    var statusText: String? = null
    var image72: String? = null
    var displayNameNormalized: String? = null
}

