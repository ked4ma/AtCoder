package com.github.ked4ma.atcoder.abc263_na

import com.github.ked4ma.atcoder.utils.*


fun main() {
    val MOD = 998244353L
    val N = nextInt()
    val A = nextIntList()
    val dp = sizedArray(N, 0L)
    val acc = sizedArray(N + 1, 0L) // accumulative sum

    for (i in N - 2 downTo 0) {
        val ai = A[i]
        dp[i] = ((acc[i + 1] - acc[i + ai + 1] + MOD) % MOD + ai + 1) * modinv(ai.toLong(), MOD) % MOD
        acc[i] = (dp[i] + acc[i + 1]) % MOD
    }

    println(dp.first())
}
