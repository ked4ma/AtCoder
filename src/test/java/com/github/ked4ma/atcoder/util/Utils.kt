package com.github.ked4ma.atcoder.util

import com.github.ked4ma.atcoder.util.http.AtcoderCookies
import com.github.ked4ma.atcoder.utils._debug_println
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.cookies.HttpCookies
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.*
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("SameParameterValue")
fun runShell(command: String): String {
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val text = reader.readLine();

    process.waitFor()

    return text
}

suspend fun HttpClient.login() {
    val url = "https://atcoder.jp/login"
    val loginPage = get<HttpResponse>(url)
    val csrfToken = Jsoup.parse(loginPage.readText())
        .select("input[name=\"csrf_token\"]")[0]
        .attr("value")
    _debug_println(csrfToken)
    _debug_println(loginPage.headers)

    val response = submitForm<HttpResponse>(
        url = url,
        formParameters = Parameters.build {
            append("csrf_token", csrfToken)
            append("username", "")
            append("password", "")
        }
    )
    _debug_println(response)
    _debug_println(response.headers)
    _debug_println(response.setCookie())
}

suspend fun HttpClient.parseTask(contest: String, task: String): List<Pair<String, String>> {
    val linkMap = parseContest(contest)
    val html = get<String>(linkMap.getValue(task))
    val re = "[入出]力例 .*".toRegex()
    return Jsoup.parse(html)
        .select(".lang-ja .part > section:nth-child(1)")
        .filter {
            it.selectFirst("h3")?.text()?.matches(re) ?: false
        }.mapNotNull {
            it.selectFirst("pre")?.text()
        }.chunked(2) {
            it[0] to it[1]
        }
}

suspend fun HttpClient.parseContest(contest: String): Map<String, String> {
    val html = get<String>("https://atcoder.jp/contests/$contest/tasks?lang=ja")
    return Jsoup.parse(html)
        .select("div.panel table.table tbody tr td:first-child a")
        .associate {
            it.text() to "https://atcoder.jp${it.attr("href")}"
        }
}

@OptIn(KtorExperimentalAPI::class)
fun HttpMessage.setCookie(): List<Cookie> = headers.getAll(HttpHeaders.SetCookie)?.map {
    parseServerSetCookieHeader(it + "; \$x-enc=RAW")
} ?: emptyList()

@OptIn(KtorExperimentalAPI::class)
fun main() {
    runBlocking {
        val client = HttpClient(CIO) {
            install(AtcoderCookies)
            install(HttpCookies)
        }
        client.login()
    }
}
