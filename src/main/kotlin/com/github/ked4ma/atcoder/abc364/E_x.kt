package com.github.ked4ma.atcoder.abc364

import com.github.ked4ma.atcoder.utils.array.int.d3.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, Y) = nextIntList()
    val dishes = times(N) {
        val (A, B) = nextIntList()
        A to B
    }
    val dp = sized3DIntArray(N + 1, N + 1, X + 1, Int.MAX_VALUE / 2)
    dp[0][0][0] = 0
    for (i in range(N)) {
        for (j in range(i + 1)) {
            for (k in range(X + 1)) {
                dp[i + 1][j][k] = min(dp[i + 1][j][k], dp[i][j][k])
                if (k + dishes[i].first <= X) {
                    dp[i + 1][j + 1][k + dishes[i].first] = min(
                        dp[i + 1][j + 1][k + dishes[i].first],
                        dp[i][j][k] + dishes[i].second
                    )
                }
            }
        }
    }
    for (j in N downTo 0) {
        for (k in range(X + 1)) {
            if (dp[N][j][k] <= Y) {
                _debug_println(dp[N][j][k])
                println(min(j + 1, N))
                return
            }
        }
    }
}
