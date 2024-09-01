package com.github.ked4ma.atcoder.abc369

import com.github.ked4ma.atcoder.utils.array.long.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val dp = sized2DLongArray(N, 2, 0)
    dp[0][1] = A[0]

    for (i in 1 until N) {
        val X = A[i]
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + 2 * X)
        dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + X)
    }

    println(dp.last().max())
}
