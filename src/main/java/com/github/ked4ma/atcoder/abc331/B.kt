package com.github.ked4ma.atcoder.abc331

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, S, M, L) = nextLongList()
    var ans = Long.MAX_VALUE
    for (s in 0..(N / 6) + 1) {
        for (m in 0..(N / 8) + 1) {
            for (l in 0..(N / 12) + 1) {
                if (6 * s + 8 * m + 12 * l >= N) ans = min(ans, S * s + M * m + L * l)
            }
        }
    }
    println(ans)
}