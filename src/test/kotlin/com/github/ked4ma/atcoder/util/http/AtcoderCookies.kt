package com.github.ked4ma.atcoder.util.http

import io.ktor.client.HttpClient
import io.ktor.client.call.save
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.statement.HttpReceivePipeline
import io.ktor.client.statement.HttpResponse
import io.ktor.util.AttributeKey

object TestAppender {
    fun convert(response: HttpResponse) = AtcoderResponse(response)
}

class AtcoderCookies {
    companion object : HttpClientPlugin<HttpCookies.Config, TestAppender> {
        override val key: AttributeKey<TestAppender> = AttributeKey("TestAppender")
        override fun prepare(block: HttpCookies.Config.() -> Unit): TestAppender = TestAppender

        override fun install(plugin: TestAppender, scope: HttpClient) {
            scope.receivePipeline.intercept(HttpReceivePipeline.Before) { response ->
                if (response.status.value in 200 until 400) {
                    val savedCall = response.call.save()
                    proceedWith(plugin.convert(savedCall.response))
                    return@intercept
                }
            }
        }
    }
}
