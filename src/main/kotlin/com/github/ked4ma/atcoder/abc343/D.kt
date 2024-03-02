package com.github.ked4ma.atcoder.abc343

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, T) = nextIntList()
    val P = sizedLongArray(N, 0L)
    val count = mutableMapOf(0L to N)
    var ans = 1
    for (i in 0 until T) {
        val (A, B) = nextIntList().let { (A, B) -> A - 1 to B.toLong() }
        count[P[A]] = count.getValue(P[A]) - 1
        if (count[P[A]] == 0) ans--
        P[A] += B
        count[P[A]] = count.getOrDefault(P[A], 0) + 1
        if (count[P[A]] == 1) ans++

        _debug_println(P.joinToString(", "))
        println(ans)
    }
}