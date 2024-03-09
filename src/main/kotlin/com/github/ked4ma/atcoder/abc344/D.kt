package com.github.ked4ma.atcoder.abc344

import com.github.ked4ma.atcoder.utils.array.long.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = next()
    val N = nextInt()
    val S = times(N) {
        nextList().drop(1)
    }

    val dp = sized2DLongArray(N + 1, T.length + 1, 1_000_000L)
    dp[0][0] = 0
    for (i in 0 until N) {
        for (j in 0 until T.length + 1) {
            dp[i + 1][j] = dp[i][j]
        }
        val s = S[i]
        for (str in s) {
            for (k in 0..T.length - str.length) {
                if (str == T.substring(k, k + str.length)) {
                    dp[i + 1][k + str.length] = min(
                        dp[i + 1][k + str.length],
                        dp[i][k] + 1
                    )
                }
            }
        }
    }

    println(if (dp.last().last() == 1_000_000L) -1 else dp.last().last())
}