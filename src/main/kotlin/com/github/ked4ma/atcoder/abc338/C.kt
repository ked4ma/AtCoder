package com.github.ked4ma.atcoder.abc338

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val Q = nextLongList()
    val A = nextLongList()
    val B = nextLongList()

    var ok = 0
    var ng = 2_000_001
    while (ok + 1 < ng) {
        val m = (ok + ng) / 2
        val c = (0..m).any { a ->
            val b = m - a
            (0 until N).all { i ->
                A[i] * a + B[i] * b <= Q[i]
            }
        }
        if (c) {
            ok = m
        } else {
            ng = m
        }
    }
    println(ok)
}