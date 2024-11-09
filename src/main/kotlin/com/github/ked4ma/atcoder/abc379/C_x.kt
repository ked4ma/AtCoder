package com.github.ked4ma.atcoder.abc379

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val X = nextIntList()
    val A = nextIntList()
    val XA = X.zip(A).sortedBy { it.first }

    if (A.fold(0L) { acc, c -> acc + c } != N.toLong()) {
        println(-1)
        return
    }

    var n = 0
    for ((X, A) in XA) {
        if (n + 1 < X) {
            println(-1)
            return
        }
        n += A
    }

    println(N.toLong() * (N + 1) / 2 - XA.fold(0L) { acc, (x, a) -> acc + a.toLong() * x })
}
