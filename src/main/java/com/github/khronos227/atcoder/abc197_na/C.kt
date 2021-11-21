package com.github.khronos227.atcoder.abc197_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextInt()
    val A = nextIntList()
    val dp = sized2DArray(N, N, 0)
    (0 until N).forEach { i ->
        dp[i][i] = A[i]
        (i + 1 until N).forEach { j ->
            dp[i][j] = dp[i][j - 1] or A[j]
        }
        _debug_println(dp[i].toList())
    }
    var min = Int.MAX_VALUE
    fun culc(i: Int = 0, n: Int = 0, debug: List<Int> = emptyList()) {
        if (i >= N) {
            _debug_println(i)
            _debug_println(debug)
            if (n < min) {
                min = n
            }
            return
        }
        (i until A.size).forEach {
            culc(it + 1, n xor dp[i][it], debug + listOf(it))
        }
    }

    culc()
    println(min)
}
