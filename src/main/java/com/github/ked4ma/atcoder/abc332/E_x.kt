package com.github.ked4ma.atcoder.abc332

import com.github.ked4ma.atcoder.utils.array.any.*
import com.github.ked4ma.atcoder.utils.array.double.*
import com.github.ked4ma.atcoder.utils.array.double.d2.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.*
import kotlin.math.min
import kotlin.math.pow

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextLongList()
    val W = nextLongList()
    val avg = W.sum().toDouble() / D
    _debug_println(avg)
    val dp = sized2DDoubleArray(1L shl N.toInt(), D + 1, 0.0)
    for (i in 0 until (1L shl N.toInt())) {
        var y = 0L
        for (j in 0 until N) {
            if (i and (1L shl j.toInt()) > 0L) {
                y += W[j]
            }
        }
        dp[i][1] = (y - avg).pow(2)
        for (k in 2..D) {
            dp[i][k] = dp[i][k - 1] + dp[0][1]
            var x = i
            while (x > 0) {
                _debug_println("$i $k ${x.toString(2)}")
                dp[i][k] = min(dp[i][k], dp[i - x][k - 1] + dp[x][1])
                x = (x - 1) and i
            }
        }
    }
    println("%.10f".format(dp[(1L shl N.toInt()) - 1][D] / D))
}