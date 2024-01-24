package com.github.ked4ma.atcoder.abc184

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val dp = Array(101) { Array(101) { Array(101) { 0.0 } } }
    fun f(a: Int, b: Int, c: Int): Double {
        if (dp[a][b][c] > 0) return dp[a][b][c]
        if (a == 100 || b == 100 || c == 100) return 0.0
        var ans = 0.0
        ans += (f(a + 1, b, c) + 1) * a / (a + b + c)
        ans += (f(a, b + 1, c) + 1) * b / (a + b + c)
        ans += (f(a, b, c + 1) + 1) * c / (a + b + c)
        dp[a][b][c] = ans
        return ans
    }

    val (a, b, c) = nextIntList()
    println(f(a, b, c))
}
