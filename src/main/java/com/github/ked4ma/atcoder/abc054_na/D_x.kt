package com.github.ked4ma.atcoder.abc054_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.min

fun main() {
    val (n, ma, mb) = nextIntList()
    val m = (0 until n).map {
        val (a, b, c) = nextIntList()
        Triple(a, b, c)
    }

    val dp = Array(n + 1) { Array(400 + 1) { Array(400 + 1) { 1_000_000 } } }
    dp[0][0][0] = 0
    for (i in (0 until n)) {
        // not use m[i]
        for (ca in (0..400)) {
            for (cb in (0..400)) {
                if (dp[i][ca][cb] == 1_000_000) continue
                dp[i + 1][ca][cb] = min(dp[i + 1][ca][cb], dp[i][ca][cb])
                dp[i + 1][ca + m[i].first][cb + m[i].second] = min(
                    dp[i + 1][ca + m[i].first][cb + m[i].second],
                    dp[i][ca][cb] + m[i].third
                )
            }
        }
    }
    var ans = 1_000_000
    var a = ma
    var b = mb
    while (a <= 400 && b <= 400) {
        ans = min(ans, dp[n][a][b])
        a += ma
        b += mb
    }
    println(ans.takeIf { it < 1_000_000 } ?: -1)
}
