package com.anttek.slack.api.response
import com.anttek.slack.api.model.*
import com.anttek.slack.api.BaseResponse

class UsersSetPhotoProfileResponse (
    var image32: String,
    var imageOriginal: String,
    var image1024: String,
    var image24: String,
    var image192: String,
    var image48: String,
    var avatarHash: String,
    var image72: String,
    var image512: String
): BaseResponse()
