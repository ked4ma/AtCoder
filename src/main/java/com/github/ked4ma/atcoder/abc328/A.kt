package com.github.ked4ma.atcoder.abc328

import com.github.ked4ma.atcoder.utils.input.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextIntList()
    println(nextIntList().filter { it <= X }.sum())
}