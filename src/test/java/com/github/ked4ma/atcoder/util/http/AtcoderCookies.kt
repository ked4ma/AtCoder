package com.github.ked4ma.atcoder.util.http

import io.ktor.client.HttpClient
import io.ktor.client.call.save
import io.ktor.client.features.HttpClientFeature
import io.ktor.client.features.cookies.HttpCookies
import io.ktor.client.statement.HttpReceivePipeline
import io.ktor.client.statement.HttpResponse
import io.ktor.util.AttributeKey
import io.ktor.util.KtorExperimentalAPI

object TestAppender {
    fun convert(response: HttpResponse) = AtcoderResponse(response)
}

class AtcoderCookies {
    companion object : HttpClientFeature<HttpCookies.Config, TestAppender> {
        override val key: AttributeKey<TestAppender> = AttributeKey("TestAppender")
        override fun prepare(block: HttpCookies.Config.() -> Unit): TestAppender = TestAppender

        @OptIn(KtorExperimentalAPI::class)
        override fun install(feature: TestAppender, scope: HttpClient) {
            scope.receivePipeline.intercept(HttpReceivePipeline.Before) { response ->
                if (response.status.value in 200 until 400) {
                    val savedCall = response.call.save()
                    proceedWith(feature.convert(savedCall.response))
                    return@intercept
                }
            }
        }
    }
}
