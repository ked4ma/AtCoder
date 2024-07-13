package com.github.ked4ma.atcoder.abc362

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d3.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.mod.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 998_244_353L
    val N = nextInt()
    val A = nextLongList()

    // dp[i][j][l]
    val dp = sized3DLongArray(N, N, N + 1, 0)

    for (i in N - 1 downTo 0) {
        for (j in i + 1 until N) {
            dp[i][j][2] = 1
            for (l in 3..N - i) {
                for (k in j + 1 until N) {
                    if (A[k] - A[j] != A[j] - A[i]) continue
                    dp[i][j][l] = dp[i][j][l].plusMod(dp[j][k][l - 1], MOD)
                }
            }
        }
    }
    val ans = sizedLongArray(N + 1, 0)
    ans[1] = N.toLong()
    for (i in range(N)) {
        for (j in i + 1 until N) {
            for (l in 2..N - i) {
                ans[l] = ans[l].plusMod(dp[i][j][l], MOD)
            }
        }
    }
    println(ans.slice(1..N).joinToString(" "))
}