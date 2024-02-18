package com.github.ked4ma.atcoder.abc341

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.gcd.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList()
    val LCM = N * M / gcd(N, M)

    fun check(x: Long): Boolean {
        return (x / N) + (x / M) - 2 * (x / LCM) >= K
    }

    var ng = 0L
    var ok = Long.MAX_VALUE
    while (ng + 1 < ok) {
        val m = (ng + ok) / 2
        if (check(m)) {
            ok = m
        } else {
            ng = m
        }
    }
    println(ok)
}