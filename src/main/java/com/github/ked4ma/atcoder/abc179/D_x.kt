package com.github.ked4ma.atcoder.abc179

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val MOD = 998_244_353
    val (n, k) = nextIntList()
    val dp = sizedArray(n, 0L)
    dp[0] = 1
    dp[1] = -1
    val s = (0 until k).map {
        val (l, r) = nextIntList()
        l to r
    }
    repeat(n) { i ->
        if (i > 0) dp[i] = dp[i].plus(dp[i - 1]).rem(MOD)
        s.forEach { (l, r) ->
            if (i + l < n) dp[i + l] = dp[i + l].plus(dp[i]).rem(MOD)
            if (i + r + 1 < n) dp[i + r + 1] = dp[i + r + 1].minus(dp[i]).plus(MOD).rem(MOD)
        }
    }
    println(dp[n - 1])
}
