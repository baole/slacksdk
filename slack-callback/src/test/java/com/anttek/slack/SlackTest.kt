package com.anttek.slack

import com.anttek.slack.api.DefaultMapper
import com.anttek.slack.api.SlackSdk
import com.anttek.slack.api.SlackSdkBuilder
import com.anttek.slack.api.request.ChatPostMessageRequest


object SlackTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val token = "valid token"
        val api = SlackSdkBuilder(AliceUtil.okHttpClient(), DefaultMapper(), token).build()
        val chatPostMessageRequest = ChatPostMessageRequest(text = "Hellooo", channel = "C04RUMAGP")
        api.chatPostMessage(chatPostMessageRequest).result?.let {
            println(it)
        }
    }
}
