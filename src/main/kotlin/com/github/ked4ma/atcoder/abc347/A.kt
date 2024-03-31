package com.github.ked4ma.atcoder.abc347

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    A.mapNotNull { n ->
        if (n % K == 0) n / K else null
    }.let {
        println(it.joinToString(" "))
    }
}