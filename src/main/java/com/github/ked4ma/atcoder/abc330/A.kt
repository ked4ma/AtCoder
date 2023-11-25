package com.github.ked4ma.atcoder.abc330

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, L) = nextIntList()
    val A = nextIntList()
    println(A.count { it >= L })
}