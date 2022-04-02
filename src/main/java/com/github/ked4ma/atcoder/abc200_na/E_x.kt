package com.github.ked4ma.atcoder.abc200_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (N, K) = nextLongList().let { (n, k) -> n.toInt() to k }

    // dp[selected count][total num]
    val dp = sized2DArray(4, 3 * N + 5, 0L)
    dp[0][0] = 1L
    for (i in 0 until 2) {
        for (j in (0..i * N)) {
            dp[i + 1][j + 1] += dp[i][j]
            dp[i + 1][j + N + 1] -= dp[i][j]
        }
        // count up for ordering
        for (j in 1..(i + 1) * N) {
            dp[i + 1][j] += dp[i + 1][j - 1]
        }
    }

    var k = K
    var x = 0
    for (i in 3..3 * N) {
        if (dp[3][i] >= k) {
            x = i
            break
        } else {
            k -= dp[3][i]
        }
    }

    // here, x is total number of (i, j, k)
    for (i in 1..N) { // fix i (beauty)
        val jmi = max(1, x - i - N) // total - i - N(max of k)
        val jma = min(N, x - i - 1) // total - i - 1(min of k)
        if (jmi > jma) continue
        if (k > (jma - jmi + 1)) { // use k var continuously to detect j
            k -= (jma - jmi + 1)
            continue
        }
        val y = jmi + k - 1 // adjust position of j with jmi and k(enable to use as offset)
        val z = x - i - y // calc remains
        println("$i $y $z")
        return
    }
}
