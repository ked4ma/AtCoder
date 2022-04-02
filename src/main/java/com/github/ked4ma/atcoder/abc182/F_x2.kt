package com.github.ked4ma.atcoder.abc182

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (n, x) = nextLongList().let { (nn, xx) ->
        nn.toInt() to xx
    }
    val a = nextLongList().toLongArray()

    val dp = sized2DArray(n + 1, 2, 0L)
    dp[0][0] = 1

    var X = x
    for (i in 0 until n - 1) {
        for (j in 0..1) {
            val d = (X + j) % a[i + 1]
            if (d == 0L) {
                dp[i + 1][j] += dp[i][j]
            } else {
                dp[i + 1][0] += dp[i][j]
                dp[i + 1][1] += dp[i][j]
            }
        }
        X /= a[i + 1]
        for (j in n - 1 downTo i + 1) {
            a[j] /= a[i + 1]
        }
    }
    dp.forEach {
        println(it.joinToString(","))
    }

    println(dp[n - 1][0] + dp[n - 1][1])
}
