package com.github.ked4ma.atcoder.abc365

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList().let { (N, M) -> N.toInt() to M }
    val A = nextLongList()

    var ok = 0L
    var ng = Int.MAX_VALUE.toLong() + 1
    while (ok + 1 < ng) {
        val m = (ok + ng) / 2
        val cost = A.sumOf { min(m, it) }
        if (cost <= M) {
            ok = m
        } else {
            ng = m
        }
    }
    println(if (ok == Int.MAX_VALUE.toLong()) "infinite" else ok)
}
