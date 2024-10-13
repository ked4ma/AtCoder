
package com.github.ked4ma.atcoder.abc375

import com.github.ked4ma.atcoder.utils.array.int.d3.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = times(N) {
        val (A, B) = nextIntList()
        A to B
    }
    val sum = P.sumOf(Pair<Int, Int>::second)
    if (sum % 3 != 0) {
        println(-1)
        return
    }
    val M = sum / 3 + 1

    val dp = sized3DIntArray(N + 1, M, M, Int.MAX_VALUE / 2)
    dp[0][0][0] = 0
    for (i in range(N)) {
        val (a, b) = P[i]
        for (j in range(M)) {
            for (k in range(M)) {
                when (a) {
                    1 -> {
                        if (j + b < M) dp[i + 1][j + b][k] = min(dp[i + 1][j + b][k], dp[i][j][k])
                        if (k + b < M) dp[i + 1][j][k + b] = min(dp[i + 1][j][k + b], dp[i][j][k] + 1)
                        dp[i + 1][j][k] = min(dp[i + 1][j][k], dp[i][j][k] + 1)
                    }

                    2 -> {
                        if (j + b < M) dp[i + 1][j + b][k] = min(dp[i + 1][j + b][k], dp[i][j][k] + 1)
                        if (k + b < M) dp[i + 1][j][k + b] = min(dp[i + 1][j][k + b], dp[i][j][k])
                        dp[i + 1][j][k] = min(dp[i + 1][j][k], dp[i][j][k] + 1)
                    }

                    3 -> {
                        if (j + b < M) dp[i + 1][j + b][k] = min(dp[i + 1][j + b][k], dp[i][j][k] + 1)
                        if (k + b < M) dp[i + 1][j][k + b] = min(dp[i + 1][j][k + b], dp[i][j][k] + 1)
                        dp[i + 1][j][k] = min(dp[i + 1][j][k], dp[i][j][k])
                    }
                }
            }
        }
    }
    val ans = dp[N][M - 1][M - 1]
    println(if (ans == Int.MAX_VALUE / 2) -1 else ans)
}
