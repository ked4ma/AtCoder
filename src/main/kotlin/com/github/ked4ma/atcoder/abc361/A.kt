package com.github.ked4ma.atcoder.abc361

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, X) = nextIntList()
    val A = nextIntList().toMutableList()

    A.add(K, X)

    println(A.joinToString(" "))
}
