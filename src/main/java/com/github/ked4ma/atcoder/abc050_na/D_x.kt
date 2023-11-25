package com.github.ked4ma.atcoder.abc050_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.*
import kotlin.math.floor
import kotlin.math.log2

fun main() {
    val mod = 1_000_000_007L
    val n = nextLong()
    val len = floor(log2(n.toDouble())).toInt() + 1
    val dp = sized2DArray(len, 3, 0L)

    dp[len - 1][0] = 1
    dp[len - 1][1] = 1
    for (i in len - 2 downTo 0) {
        if ((n shr i) % 2 == 1L) {
            // diff of previous bit = 0
            // and if a[i] = 1 && b[i] = 1, a + b will be larger than N
            dp[i][0] = dp[i + 1][0]
            // diff of current bit = 0, previous = 1
            // diff of current bit = 1, previous = 0
            dp[i][1] = dp[i + 1][1].plus(dp[i + 1][0], mod)
            dp[i][2] = dp[i + 1][2].times(3).plus(dp[i + 1][1].times(2, mod), mod)
        } else {
            dp[i][0] = dp[i + 1][0].plus(dp[i + 1][1], mod)
            dp[i][1] = dp[i + 1][1]
            dp[i][2] = dp[i + 1][2].times(3).plus(dp[i + 1][1], mod)
        }
    }
    println(dp[0].sum().rem(mod))
}
