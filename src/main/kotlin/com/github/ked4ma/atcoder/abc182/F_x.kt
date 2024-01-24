package com.github.ked4ma.atcoder.abc182

import com.github.ked4ma.atcoder.utils.array.any.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (n, x) = nextLongList().let { (nn, xx) ->
        nn.toInt() to xx
    }
    val a = nextLongList()
    val dp = sized2DArray(n, 2, 0L)
    dp[n - 1][0] = 1
    dp[n - 1][1] = 1

    println(x)
    for (i in (n - 2 downTo 0)) {
        val d = x % a[i + 1] / a[i]
        if (d == 0L) {
            dp[i][0] = dp[i + 1][0]
        } else {
            dp[i][0] = dp[i + 1][0] + dp[i + 1][1]
        }
        if (d == a[i + 1] / a[i] - 1) {
            dp[i][1] = dp[i + 1][1]
        } else {
            dp[i][1] = dp[i + 1][0] + dp[i + 1][1]
        }

        println("-----")
        println("d: $d  (${x % a[i + 1]}, ${a[i]}, ${a[i + 1]}: ${a[i + 1] / a[i]})")
        for (j in 0..1) {
            println((0 until n).map { dp[it][j] }.joinToString(","))
        }
    }

    println("=====")
    println(dp[0][0])
}
