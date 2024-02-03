package com.github.ked4ma.atcoder.abc339

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()

    var MIN = Long.MAX_VALUE
    var S = 0L
    A.forEach { a ->
        S += a
        MIN = min(MIN, S)
    }
    if (MIN < 0L) {
        S += abs(MIN)
    }
    println(S)
}