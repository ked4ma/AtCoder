package com.github.ked4ma.atcoder.abc376

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d2.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (N, Q) = nextIntList()

    fun move(from: Int, to: Int, ng: Int): List<Pair<Int, Int>> {
        val res = mutableListOf<Pair<Int, Int>>() // cost, npos
        if (to != ng) {
            if (ng in min(from, to)..max(from, to)) {
                res.add(N - abs(from - to) to ng)
            } else {
                res.add(abs(from - to) to ng)
            }
        }
        if (from < ng) {
            if (from < to && to <= ng) {
                res.add(N - (to - from) + (ng - to + 1) to to - 1)
            }
            if (to < from || ng <= to)
                res.add((to - from + N) % N + (to - ng + N) % N + 1 to (to + 1) % N)
        } else {
            if (ng <= to && to < from) {
                res.add((N - (from - to)) + (to - ng + 1) to to + 1)
            }
            if (to <= ng || from < to) {
                res.add((from - to + N) % N + (ng - to + N) % N + 1 to (to - 1 + N) % N)
            }
        }
        return res
    }

    val dp = sized2DIntArray(Q + 1, N, Int.MAX_VALUE / 2)
    dp[0][1] = 0
    var ph = 0
    var pt = 0
    for (i in range(Q)) {
        val (H, T) = nextList().let { (H, T) -> (if (H == "L") 0 else 1) to T.toInt() - 1 }
        for (j in range(N)) {
            if (dp[i][j] == Int.MAX_VALUE / 2) continue
            val pos = sizedIntArray(2, 0)
            pos[ph] = pt
            pos[ph xor 1] = j
            for ((cost, npos) in move(pos[H], T, pos[H xor 1])) {
                dp[i + 1][npos] = min(dp[i + 1][npos], dp[i][j] + cost)
            }
        }
        ph = H
        pt = T
    }
    println(dp.last().min())
}
