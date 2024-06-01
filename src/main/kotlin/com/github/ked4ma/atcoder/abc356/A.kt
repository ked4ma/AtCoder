package com.github.ked4ma.atcoder.abc356

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextIntList()
    val A = (1..N).toList().toIntArray()
    var l = L - 1
    var r = R - 1
    while (l < r) {
        val t = A[l]
        A[l] = A[r]
        A[r] = t
        l++
        r--
    }
    println(A.joinToString(" "))
}
