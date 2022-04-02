@file:OptIn(KtorExperimentalAPI::class)

package com.github.ked4ma.atcoder

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.lang.reflect.Method

private fun runShell(command: String): String {
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val text = reader.readLine();
    process.waitFor()

    return text
}

private suspend fun HttpClient.parseContest(contest: String): Map<String, String> {
    val html = get<String>("https://atcoder.jp/contests/$contest/tasks?lang=ja")
    return Jsoup.parse(html)
        .select("div.panel table.table tbody tr td:first-child a")
        .associate {
            it.text() to "https://atcoder.jp${it.attr("href")}"
        }
}

private suspend fun HttpClient.parseTask(contest: String, task: String): List<Pair<String, String>> {
    val linkMap = parseContest(contest)
    val html = get<String>(linkMap.getValue(task))
    val re = "(入|出)力例 .*".toRegex()
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

private fun execSamples(contest: String, task: String, samples: List<Pair<String, String>>) {
    val originalInputStream = System.`in`
    val inputStream = PipedInputStream()
    val outputStream = PipedOutputStream(inputStream)
    System.setIn(inputStream)

    val method = Class.forName("com.github.ked4ma.atcoder.$contest.${task}Kt")
        .getMethod("main") ?: run {
        println("target method is not found ($contest/$task)")
        return
    }

    runBlocking {
        samples.forEach {
            execSample(method, it, outputStream)
        }
    }

    // rollback input stream
    System.setIn(originalInputStream)
    outputStream.close()
    inputStream.close()
}

private suspend fun execSample(
    method: Method,
    sample: Pair<String, String>,
    outputStream: PipedOutputStream
) = coroutineScope {
    println("=====")
    listOf(
        launch {
            method.invoke(null)
        },
        launch(Dispatchers.IO) {
            outputStream.write("${sample.first}\n".toByteArray())
            outputStream.flush()
        }
    ).joinAll()
    println("-----")
    println(sample.second)
    println("=====")
}

fun main() {
    val branch = runShell("git branch --show-current")
    val contestRegex = "feature/(.+)".toRegex()
    val contestDirName = contestRegex.matchEntire(branch)?.groupValues?.get(1)?.let {
        it.replace("_test", "")
    } ?: run {
        println("[CAUTION]: Nothing to execute because current branch is \"$branch\".")
        return
    }
    val task = "A"
    println(branch)
    println(contestDirName)
    val samples = runBlocking {
        val client = HttpClient(CIO)
        val samples = client.parseTask(contestDirName.split("_")[0], task)
        client.close()
        return@runBlocking samples
    }

    execSamples(contestDirName, task, samples)
}
