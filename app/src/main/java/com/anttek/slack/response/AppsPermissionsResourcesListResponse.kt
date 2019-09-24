package com.anttek.slack.response
import com.anttek.slack.model.*

class AppsPermissionsResourcesListResponse (
    var resources: ArrayList<Any>,
    var responseMetadata: AppsPermissionsResourcesListResponseMetadataResponse? = null,
    var ok: Boolean
)
