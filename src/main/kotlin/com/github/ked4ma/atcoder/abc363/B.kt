package com.github.ked4ma.atcoder.abc363

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, T, P) = nextIntList()
    val L = nextIntList().sortedDescending()
    println((T - L[P - 1]).coerceAtLeast(0))
}
