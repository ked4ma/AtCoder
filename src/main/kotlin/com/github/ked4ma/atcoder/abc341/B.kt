package com.github.ked4ma.atcoder.abc341

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList().toLongArray()
    repeat(N - 1) { i ->
        val (s, t) = nextLongList()
        A[i + 1] += (A[i] / s) * t
    }
    println(A.last())
}