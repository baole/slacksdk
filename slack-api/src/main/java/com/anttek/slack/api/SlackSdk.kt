package com.anttek.slack.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder

/**
 * Created by duc-d on 8/24/2017.
 */
class SlackSdk(client: OkHttpClient, mapper: Mapper) {
    companion object {
        const val SLACK_API_ENDPOINT = "https://slack.com/api/"
    }

    private var api: SlackApi
    fun api(token: String): SlackApi {
        return api.token(token);
    }

    init {
        val service = Builder()
                .addConverterFactory(SlackConverterFactory.create())
                .baseUrl(SLACK_API_ENDPOINT)
                .client(client)
                .build()
                .create(SlackService::class.java)
        api = SlackApi(service, mapper)
    }
}
