package com.github.ked4ma.atcoder.abc343

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) {
        nextIntList()
    }
    for (e in A) {
        val sb = StringJoiner(" ")
        e.forEachIndexed { i, a ->
            if (a == 1) {
                sb.add((i + 1).toString())
            }
        }
        println(sb)
    }
}