package com.github.ked4ma.atcoder

import com.github.ked4ma.atcoder.util.http.AtcoderCookies
import com.github.ked4ma.atcoder.util.parseTask
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.cookies.HttpCookies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.lang.reflect.Method

// TODO consider to commonize to reusable codes
class AtCoderProblemsTestRunner {
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
        private lateinit var CONTEST: String
        private lateinit var TASK: String
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
            val clazz = Class.forName("com.github.ked4ma.atcoder.problems.CodeKt")
            CONTEST = clazz.getDeclaredField("CONTEST").get(clazz) as String
            TASK = clazz.getDeclaredField("TASK").get(clazz) as String
            METHOD = clazz.getMethod("main")

            System.setIn(INPUT_STREAM)

            CLIENT = HttpClient(CIO) {
                install(AtcoderCookies)
                install(HttpCookies)
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
                println("target method is not found (contest=$CONTEST, task=$TASK)")
                return emptyList()
            }

            return runBlocking {
                val samples = CLIENT.parseTask(
                    CONTEST,
                    TASK,
                )
                CLIENT.close()
                return@runBlocking samples
            }.map { (input, expected) ->
                Arguments.of(input, expected)
            }
        }
    }
}
