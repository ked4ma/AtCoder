package com.github.ked4ma.atcoder.abc324

import com.github.ked4ma.atcoder.utils.input.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().toSet()
    println(if (A.size == 1) "Yes" else "No")
}