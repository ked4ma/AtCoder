package com.github.ked4ma.atcoder.abc370

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) {
        nextIntList().map { it - 1 }
    }
    var a = 0
    for (b in range(N)) {
        a = if (a >= b) {
            A[a][b]
        } else {
            A[b][a]
        }
    }
    println(a + 1)
}
