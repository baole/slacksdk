package com.anttek.slack.api

import retrofit2.Call
import java.io.IOException

/**
 * Created by duc-d on 8/24/2017.
 */
abstract class BaseSlackApi {

    protected fun <T> getResponse(call: Call<T>): SlackResponse<T> {
        try {
            call.execute().let { response ->
                return if (response.isSuccessful) {
                    SlackResponse(response.body())
                } else {
                    SlackResponse<T>(httpCode = response.code())
                }
            }
        } catch (e: IOException) {
            return SlackResponse<T>(exception = e)
        }
    }
}
