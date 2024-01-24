package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    timesWithLong(N) {
        N.toString()
    }.joinToString("").let {
        println(it)
    }
}