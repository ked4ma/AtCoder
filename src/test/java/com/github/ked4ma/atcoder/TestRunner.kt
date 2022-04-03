@file:OptIn(KtorExperimentalAPI::class)

package com.github.ked4ma.atcoder

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
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
    listOf(
        launch {
            method.invoke(null)
        },
        launch(Dispatchers.IO) {
            outputStream.write("${sample.first}\n".toByteArray())
            outputStream.flush()
        }
    ).joinAll()
}

class TestRunner {
    @ParameterizedTest
    @MethodSource("sampleProvider")
    fun testEachSample(input: String, expected: String) = runBlocking {
        val out = PrintCaptureStream()
        println("----- input ------")
        println(input)
        println("----- actual -----")
        withContext(Dispatchers.IO) {
            System.setOut(out)
        }
        execSample(METHOD!!, input to expected, OUTPUT_STREAM)
        val actual = withContext(Dispatchers.IO) {
            val s = out.read()
            System.setOut(ORIGINAL_OUTPUT_STREAM)
            out.close()
            return@withContext s
        }
        println(actual)
        println("---- expected ----")
        println(expected)
        assertEquals(actual, expected)
    }

    companion object {
        private lateinit var TASK: String
        private lateinit var BRANCH: String
        private var CONTEST_DIR: String? = null
        private var METHOD: Method? = null

        private val ORIGINAL_INPUT_STREAM = System.`in`
        private val ORIGINAL_OUTPUT_STREAM = System.out
        private val INPUT_STREAM = PipedInputStream()
        private val OUTPUT_STREAM = PipedOutputStream(INPUT_STREAM)

        @Suppress("unused")
        @BeforeAll
        @JvmStatic
        fun setup() {
            TASK = System.getProperty("task")?.takeIf(String::isNotBlank) ?: "A"
            BRANCH = runShell("git branch --show-current")
            val contestRegex = "feature/(.+)".toRegex()
            CONTEST_DIR = contestRegex.matchEntire(BRANCH)?.groupValues?.get(1)
                ?.replace("_test", "")
            println("$BRANCH, $TASK")

            METHOD = Class.forName("com.github.ked4ma.atcoder.$CONTEST_DIR.${TASK}Kt")
                .getMethod("main")

            System.setIn(INPUT_STREAM)
        }

        @Suppress("unused")
        @AfterAll
        @JvmStatic
        fun teardown() {
            System.setIn(ORIGINAL_INPUT_STREAM)
        }

        @JvmStatic
        fun sampleProvider(): List<Arguments> {
            METHOD ?: run {
                println("target method is not found ($CONTEST_DIR/$TASK)")
                return emptyList()
            }
            val contestDir = CONTEST_DIR ?: run {
                println("[CAUTION]: Nothing to execute because current branch is \"$BRANCH\".")
                return emptyList()
            }
            return runBlocking {
                val client = HttpClient(CIO)
                val samples = client.parseTask(
                    contestDir.split("_")[0],
                    TASK.split("_")[0]
                )
                client.close()
                return@runBlocking samples
            }.map { (input, expected) ->
                Arguments.of(input, expected)
            }
        }
    }
}
