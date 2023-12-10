package com.github.ked4ma.atcoder.abc332

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, S, K) = nextLongList()
    val total = times(N) {
        val (P, Q) = nextLongList()
        P * Q
    }.sum()
    println(total + if (total >= S) 0L else K)
}