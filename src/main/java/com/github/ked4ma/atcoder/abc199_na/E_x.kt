package com.github.ked4ma.atcoder.abc199_na

import com.github.ked4ma.atcoder.utils.*

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val (N, M) = nextIntList()
    val restrictions = Array<MutableList<Pair<Int, Int>>>(N + 1) { mutableListOf() }
    repeat(M) {
        val (x, y, z) = nextIntList()
        restrictions[x].add(y to z)
    }
    val dp = Array(1 shl N) { 0L }
    dp[0] = 1

    for (i in 1 until (1 shl N)) {
        var ok = true
        val x = i.countOneBits()
        for ((y, z) in restrictions[x]) {
            if ((((1 shl y) - 1) and i).countOneBits() > z) {
                ok = false
                break
            }
        }
        if (!ok) continue
        for (j in 0 until N) {
            if (i and (1 shl j) > 0) {
                dp[i] += dp[i xor (1 shl j)]
            }
        }
    }
    print(dp[(1 shl N) - 1])
}
