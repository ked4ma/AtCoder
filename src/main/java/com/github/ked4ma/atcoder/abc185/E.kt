package com.github.ked4ma.atcoder.abc185

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (n, m) = nextIntList()
    val a = nextIntList()
    val b = nextIntList()

    val dp = sized2DArray(n + 1, m + 1, Int.MAX_VALUE)
    dp[0][0] = 0

    for (i in 0..n) {
        for (j in 0..m) {
            // change operation
            if (i > 0 && j > 0) {
                if (a[i - 1] == b[j - 1]) {
                    if (dp[i][j] > dp[i - 1][j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1]
                    }
                } else {
                    if (dp[i][j] > dp[i - 1][j - 1] + 1) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                    }
                }
            }

            // delete operation
            if (i > 0 && dp[i][j] > dp[i - 1][j] + 1) {
                dp[i][j] = dp[i - 1][j] + 1
            }

            if (j > 0 && dp[i][j] > dp[i][j - 1] + 1) {
                dp[i][j] = dp[i][j - 1] + 1
            }
        }
    }

    println(dp[n][m])
}
