package com.github.ked4ma.atcoder.abc365

import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next().toCharArray().map {
        when (it) {
            'R' -> 0
            'P' -> 1
            else -> 2
        }
    }
    _debug_println(S)
    val p = sized2DIntArray(N, 3, 0)
    for (i in range(N)) {
        val s = S[i]
        p[i][(s + 1) % 3] = 1
    }

    // R: 0
    // P: 1
    // S: 2
    val dp = sized2DIntArray(N, 3, 0)
    dp[0][(S[0] + 1) % 3] = 1
    val c = setOf(0, 1, 2)
    _debug_println(c - (S[1] + 1) % 3)
    _debug_println(c - S[1])
    for (i in 1 until N) {
        // even
        (c - S[i]).forEach { j ->
            if ((S[i - 1] + 2) % 3 == j) return@forEach // lose
            dp[i][S[i]] = max(
                dp[i][S[i]],
                dp[i - 1][j]
            )
        }
        // wip
        (c - (S[i] + 1) % 3).forEach { j ->
            if ((S[i - 1] + 2) % 3 == j) return@forEach
            dp[i][(S[i] + 1) % 3] = max(
                dp[i][(S[i] + 1) % 3],
                dp[i - 1][j] + 1
            )
        }
    }
    println(dp.last().max())
}
