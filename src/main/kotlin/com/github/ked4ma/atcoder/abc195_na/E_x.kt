package com.github.ked4ma.atcoder.abc195_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val N = nextInt()
    val S = next().toCharArray().map { it - '0' }
    val X = next().toCharArray()
    _debug_println(S)

    val dp = sizedArray(N + 1, setOf(0))
    for (i in N downTo 1) {
        val x = X[i - 1]
        _debug_println("$x: ${S[i - 1]}")
        if (x == 'T') {
            dp[i - 1] = (0..6).filter { r ->
                (10 * r) % 7 in dp[i] || ((10 * r + S[i - 1]) % 7) in dp[i]
            }.toSet()
        } else {
            dp[i - 1] = (0..6).filter { r ->
                (10 * r) % 7 in dp[i] && ((10 * r + S[i - 1]) % 7) in dp[i]
            }.toSet()
        }
        _debug_println("dp[$i]: ${dp[i]}")
    }
    println(if (0 in dp[0]) "Takahashi" else "Aoki")
}
