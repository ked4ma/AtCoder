package com.github.ked4ma.atcoder.util.http

import io.ktor.client.call.HttpClientCall
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Headers
import io.ktor.http.HttpProtocolVersion
import io.ktor.http.HttpStatusCode
import io.ktor.util.StringValues
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import kotlin.coroutines.CoroutineContext

class AtcoderResponse(origin: HttpResponse) : HttpResponse() {
    override val call: HttpClientCall = origin.call
    override val status: HttpStatusCode = origin.status
    override val version: HttpProtocolVersion = origin.version
    override val requestTime: GMTDate = origin.requestTime
    override val responseTime: GMTDate = origin.responseTime
    override val headers: Headers = Headers.build {
        (origin.headers as StringValues).entries().forEach { (key, values) ->
            when (key) {
                "Set-Cookie" -> appendAll(key, values.map { "$it; \$x-enc=RAW" })
                else -> appendAll(key, values)
            }
        }
    }
    override val coroutineContext: CoroutineContext = origin.coroutineContext
    override val content: ByteReadChannel = origin.content
}
