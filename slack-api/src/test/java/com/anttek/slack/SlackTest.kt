package com.anttek.slack

import com.anttek.slack.request.ChatPostMessageRequest

object SlackTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val token = "xoxp-4878724429-4878724477-350528314386-f68d47ea6cd60fbed5cef8f12dbff576"
        val api = Slack(AliceUtil.okHttpClient(), DefaultMapper()).api(token)

//        api.channels().result?.channels?.forEach {
//            println(it)
//        }

        val chatPostMessageRequest = ChatPostMessageRequest(text = "Hellooo", channel = "C04RUMAGP")
        api.chatPost(chatPostMessageRequest).result?.let {
            println(it)
        }
    }
}
