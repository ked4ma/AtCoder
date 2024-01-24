package com.github.ked4ma.atcoder.util

import com.github.ked4ma.atcoder.util.http.AtcoderCookies
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.parameters
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

suspend fun HttpClient.login(user: String, password: String) {
    val url = "https://atcoder.jp/login"
    val loginPage = get(url)
    val csrfToken = Jsoup.parse(loginPage.bodyAsText())
        .select("input[name=\"csrf_token\"]")[0]
        .attr("value")

    submitForm(
        url,
        formParameters = parameters {
            append("csrf_token", csrfToken)
            append("username", user)
            append("password", password)
        }
    )
}

suspend fun HttpClient.parseTask(contest: String, task: String): List<Pair<String, String>> {
    val linkMap = parseContest(contest)
    val html = get(linkMap.getValue(task)).bodyAsText()
    val re = "[入出]力例 .*".toRegex()
    return Jsoup.parse(html)
        .select(".lang-ja .part > section:nth-child(1)")
        .filter { it ->
            it.selectFirst("h3")?.text()?.matches(re) ?: false
        }.mapNotNull {
            it.selectFirst("pre")?.text()?.split("\n")
                ?.joinToString(separator = "\n", transform = String::trim)
        }.chunked(2) {
            it[0] to it[1]
        }
}

suspend fun HttpClient.parseContest(contest: String): Map<String, String> {
    val html = get { url("https://atcoder.jp/contests/$contest/tasks?lang=ja") }.bodyAsText()
    return Jsoup.parse(html)
        .select("div.panel table.table tbody tr td:first-child a")
        .associate {
            it.text() to "https://atcoder.jp${it.attr("href")}"
        }
}

fun main() {
    runBlocking {
        val client = HttpClient(CIO) {
            install(AtcoderCookies)
            install(HttpCookies)
        }
        client.login("", "")
        println(client.parseContest("practice2"))
    }
}
