package com.github.ked4ma.atcoder.abc354

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val cards = times(N) { i ->
        val (A, C) = nextIntList()
        Triple(i + 1, A, C)
    }.sortedBy { it.third }

    val ans = mutableListOf<Int>()
    var v = 0;

    for ((i, A, C) in cards) {
        if (v < A) {
            ans.add(i)
            v = A
        }
    }

    println(ans.size)
    println(ans.sorted().joinToString(" "))
}
