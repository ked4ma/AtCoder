package com.github.ked4ma.atcoder.abc372

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998_244_353L
    val (N, M, K) = nextIntList()
    val XY = times(M) {
        val (x, y) = nextIntList().map { it - 1 }
        x to y
    }
    val dp = sizedLongArray(N + K, 0)
    var left = K
    dp[K] = 1
    repeat(K) {
        val add = XY.map { (x, y) ->
            y to dp[left + x]
        }
        left -= 1
        dp[left] = dp[left + N]
        for ((y, v) in add) {
            dp[y + left] = dp[y + left].plusMod(v, MOD)
        }
    }
    println(dp.slice(range(N)).fold(0L) { acc, n -> acc.plusMod(n, MOD) })
}