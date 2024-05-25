package com.github.ked4ma.atcoder.abc355

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextIntList().toSet()
    val ans = listOf(1, 2, 3).filter { it !in S }
    if (ans.size == 1) {
        println(ans.first())
    } else {
        println(-1)
    }
}
