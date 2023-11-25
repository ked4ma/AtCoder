package com.github.ked4ma.atcoder.abc044_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (n, a) = nextIntList()
    val x = nextIntList()
    val mx = (x + a).max() ?: a

    val dp = Array(n + 1) { Array(n + 1) { Array(n * mx + 1) { 0L } } }
    (0..n).forEach { j ->
        (0..n).forEach { k ->
            (0..(n * mx)).forEach { s ->
                when {
                    j == 0 && k == 0 && s == 0 -> dp[j][k][s] = 1
                    j > 0 && s < x[j - 1] -> dp[j][k][s] = dp[j - 1][k][s]
                    j > 0 && k > 0 && s >= x[j - 1] -> dp[j][k][s] = dp[j - 1][k][s] + dp[j - 1][k - 1][s - x[j - 1]]
                    else -> dp[j][k][s] = 0
                }
            }
        }
    }
    println((1..n).map {
        dp[n][it][it * a]
    }.sum())
}
