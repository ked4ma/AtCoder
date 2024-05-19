package com.github.ked4ma.atcoder.abc354

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val users = times(N) {
        val (S, C) = nextList()
        S to C.toInt()
    }.sortedBy { it.first }
    val T = users.sumOf { it.second }
    println(users[T % N].first)
}
