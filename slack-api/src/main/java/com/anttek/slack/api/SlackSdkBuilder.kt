package com.anttek.slack.api

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * Created by duc-d on 8/24/2017.
 */
class SlackSdkBuilder(private val client: OkHttpClient? = null, private val mapper: Mapper? = null, private  val token: String? = null) {
    companion object {
        const val SLACK_API_ENDPOINT = "https://slack.com/api/"
    }

    fun build(): SlackSdk {
        val httpClient = client ?: OkHttpClient
                .Builder()
                .build()

        // TODO objectmapper.configure
        val service = Builder()
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
                .baseUrl(SLACK_API_ENDPOINT)
                .client(httpClient)
                .build()
                .create(SlackService::class.java)
        val slackMapper = mapper ?: DefaultMapper()

        val sdk = SlackSdk(service, slackMapper)
        token?.let { sdk.token(it) }

        return sdk
    }

}
