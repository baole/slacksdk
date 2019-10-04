package com.anttek.slack.api.request

import com.anttek.slack.api.GenericRequest

class UsersSetPhotoRequest (
         token: String? = null,
        val image: String? = null,
        val crop_w: Long? = null,
        val crop_y: Long? = null,
        val crop_x: Long? = null
) : GenericRequest(token)
