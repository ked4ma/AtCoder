package com.github.ked4ma.atcoder

import com.github.ked4ma.atcoder.util.http.AtcoderCookies
import com.github.ked4ma.atcoder.util.login
import com.github.ked4ma.atcoder.util.parseTask
import com.github.ked4ma.atcoder.util.runShell
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.cookies.HttpCookies
import kotlinx.coroutines.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.lang.reflect.Method

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
        execSample(METHOD!!, input, OUTPUT_STREAM)
        val actual = withContext(Dispatchers.IO) {
            val s = out.read()
            System.setOut(ORIGINAL_OUTPUT_STREAM)
            out.close()
            return@withContext s
        }
        println(actual)
        val actualWithoutDebug = actual.split("\n")
            .filterNot { it.startsWith("[DEBUG]") }
            .joinToString(separator = "\n")
        println("---- expected ----")
        println(expected)
        assertEquals(expected, actualWithoutDebug)
    }

    private suspend fun execSample(
        method: Method,
        input: String,
        outputStream: PipedOutputStream
    ) = coroutineScope {
        listOf(
            launch {
                method.invoke(null)
            },
            launch(Dispatchers.IO) {
                outputStream.write("$input\n".toByteArray())
                outputStream.flush()
            }
        ).joinAll()
    }

    companion object {
        private lateinit var TASK: String
        private lateinit var BRANCH: String
        private var CONTEST_DIR: String? = null
        private var METHOD: Method? = null
        private lateinit var CLIENT: HttpClient

        private val ORIGINAL_INPUT_STREAM = System.`in`
        private val ORIGINAL_OUTPUT_STREAM = System.out
        private val INPUT_STREAM = PipedInputStream()
        private val OUTPUT_STREAM = PipedOutputStream(INPUT_STREAM)

        @Suppress("unused")
        @BeforeAll
        @JvmStatic
        fun setup() {
            TASK = System.getProperty("task")?.takeIf(String::isNotBlank) ?: "A"
            BRANCH = System.getProperty("branch")?.takeIf(String::isNotBlank) ?: runShell("git branch --show-current")
            val contestRegex = "contest/(.+)".toRegex()
            CONTEST_DIR = contestRegex.matchEntire(BRANCH)?.groupValues?.get(1)
                ?.replace("_test", "")
            println("$BRANCH, $TASK")
            println("$CONTEST_DIR")

            METHOD = Class.forName("com.github.ked4ma.atcoder.$CONTEST_DIR.${TASK}Kt")
                .getMethod("main")

            System.setIn(INPUT_STREAM)

            CLIENT = HttpClient(CIO) {
                install(AtcoderCookies)
                install(HttpCookies)
            }
            if (!BRANCH.endsWith("_na")) {
                runBlocking(Dispatchers.IO) {
                    val user = System.getenv("ATCODER_USER")
                    val password = System.getenv("ATCODER_PASSWORD")
                    CLIENT.login(user, password)
                }
            }
        }

        @Suppress("unused")
        @AfterAll
        @JvmStatic
        fun teardown() {
            System.setIn(ORIGINAL_INPUT_STREAM)
            CLIENT.close()
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
                val samples = CLIENT.parseTask(
                    contestDir.split("_")[0],
                    TASK.split("_")[0]
                )
                CLIENT.close()
                return@runBlocking samples
            }.map { (input, expected) ->
                Arguments.of(input, expected)
            }
        }
    }
}
