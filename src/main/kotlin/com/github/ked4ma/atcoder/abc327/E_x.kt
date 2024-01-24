package com.github.ked4ma.atcoder.abc327

import com.github.ked4ma.atcoder.utils.array.any.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    val dp = sized2DArray(N + 1, N + 1, 0.0)
    for (i in 1..N) {
        for (j in 1..N) {
            dp[i][j] = when (j) {
                // 1 -> {
                //     max(
                //         dp[i - 1][1],
                //         P[i - 1].toDouble(),
                //     )
                // }
                // NOTE: FOLLOWING WILL AFFECT TO THE RESULT
                // if j == i, we have to include all nodes
                // must not to be maxed.
                i -> dp[i - 1][j - 1] * 0.9 + P[i - 1]
                else -> {
                    max(
                        dp[i - 1][j],
                        dp[i - 1][j - 1] * 0.9 + P[i - 1],
                    )
                }
            }
        }
    }
    var b = 0.0
    var ans = Double.NEGATIVE_INFINITY
    for (n in 1..N) {
        b = b * 0.9 + 1.0
        ans = max(ans, (dp[N][n] / b) - (1200 / sqrt(n.toDouble())))
    }
    println("%.15f".format(ans))
}