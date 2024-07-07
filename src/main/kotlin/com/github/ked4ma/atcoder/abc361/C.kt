package com.github.ked4ma.atcoder.abc361

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val M = N - K
    _debug_println(M)
    val A = nextIntList().sorted()
    _debug_println(A)

    var ans = Int.MAX_VALUE
    for (i in M - 1 until N) {
        ans = min(ans, A[i] - A[i - (M - 1)])
    }

    println(ans)
}
