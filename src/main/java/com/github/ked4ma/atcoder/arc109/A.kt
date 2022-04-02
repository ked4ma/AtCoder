package com.github.ked4ma.atcoder.arc109

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.min

fun main() {
    val (a, b, x, y) = nextIntList()

    val dp = sized2DArray(101, 2, Int.MAX_VALUE)
    dp[a][0] = 0
    dp[a][1] = x
    var ca = a
    while (ca != b) {
        if (a > b) {
            ca -= 1
            dp[ca][1] = dp[ca + 1][0] + x
            dp[ca][0] = min(dp[ca + 1][0] + y, dp[ca][1] + x)
        } else {
            val n = min(dp[ca][0] + y, dp[ca][1] + x)
            ca += 1
            dp[ca][0] = n
            dp[ca][1] = min(dp[ca][0] + x, dp[ca - 1][1] + y)
        }
    }
//    println("===")
//    for (i in b downTo a) {
//        println(dp[i].joinToString(","))
//    }
//    for (i in a downTo b) {
//        println(dp[i].joinToString(","))
//    }
//    println("===")
    println(dp[b][1])
}
