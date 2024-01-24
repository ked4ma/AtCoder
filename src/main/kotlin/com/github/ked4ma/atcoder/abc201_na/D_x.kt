package com.github.ked4ma.atcoder.abc201_na

import com.github.ked4ma.atcoder.utils.array.any.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (h, w) = nextIntList()
    val board = (0 until h).map {
        next().toCharArray()
    }
    val dp = sized2DArray(h, w, 0)

    fun f(r: Int, c: Int) = if (board[r][c] == '+') 1 else -1

    for (i in h - 1 downTo 0) {
        for (j in w - 1 downTo 0) {
            if (i == h - 1 && j == w - 1) continue
            if ((i + j) % 2 == 0) { // takahashi
                dp[i][j] = Int.MIN_VALUE
                if (i < h - 1) dp[i][j] = max(dp[i][j], dp[i + 1][j] + f(i + 1, j))
                if (j < w - 1) dp[i][j] = max(dp[i][j], dp[i][j + 1] + f(i, j + 1))
            } else {
                dp[i][j] = Int.MAX_VALUE
                if (i < h - 1) dp[i][j] = min(dp[i][j], dp[i + 1][j] - f(i + 1, j))
                if (j < w - 1) dp[i][j] = min(dp[i][j], dp[i][j + 1] - f(i, j + 1))
            }
        }
    }
    val v = dp[0][0]
    println(
        if (v > 0) {
            "Takahashi"
        } else if (v < 0) {
            "Aoki"
        } else {
            "Draw"
        }
    )
}
