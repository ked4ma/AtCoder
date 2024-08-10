package com.github.ked4ma.atcoder.abc366

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, T, A) = nextIntList()
    val rem = N - T - A
    val diff = abs(T - A)
    println(if (diff > rem) "Yes" else "No")
}
