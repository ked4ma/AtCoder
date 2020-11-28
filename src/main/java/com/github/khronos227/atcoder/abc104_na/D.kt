package com.github.khronos227.atcoder.abc104_na

import com.github.khronos227.atcoder.utils.*

// dp[s.length][3] = 1
// dp[s.length][j < 3] = 0
// として、i,jに関して降順に求めるっていうのがポイント
fun main() {
    val MOD = 1_000_000_007
    val s = next()
    val dp = sized2DArray(s.length + 1, 4, 0L)
    dp[s.length][3] = 1
    (s.lastIndex downTo 0).forEach { i ->
        val c = s[i]
        val m1 = if (c == '?') 3 else 1
        dp[i][3] = (dp[i + 1][3] * m1).rem(MOD)
        (2 downTo 0).forEach { j ->
            val m2 = when {
                c == '?' -> 1
                j == 0 && c == 'A' -> 1
                j == 1 && c == 'B' -> 1
                j == 2 && c == 'C' -> 1
                else -> 0
            }
            dp[i][j] = ((m1 * dp[i + 1][j]).rem(MOD) + (m2 * dp[i + 1][j + 1]).rem(MOD)).rem(MOD)
        }
    }
    println(dp[0][0])
}
