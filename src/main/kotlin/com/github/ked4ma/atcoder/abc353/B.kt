package com.github.ked4ma.atcoder.abc353

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    var ans = 0
    var k = 0
    for (a in A) {
        if (k + a <= K) {
            k += a
        } else {
            ans++
            k = a
        }
    }
    if (k > 0) {
        ans++
    }
    println(ans)
}
