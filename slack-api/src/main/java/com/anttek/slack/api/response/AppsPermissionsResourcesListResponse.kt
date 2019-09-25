package com.anttek.slack.api.response
import com.anttek.slack.api.model.*

class AppsPermissionsResourcesListResponse (
    var resources: ArrayList<Any>,
    var responseMetadata: AppsPermissionsResourcesListResponseMetadataResponse? = null,
    var ok: Boolean
)
