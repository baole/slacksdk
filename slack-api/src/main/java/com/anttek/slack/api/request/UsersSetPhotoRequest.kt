package com.anttek.slack.api.request

data class UsersSetPhotoRequest (
        val image: String? = null,
        val crop_w: Long? = null,
        val crop_y: Long? = null,
        val crop_x: Long? = null
)
