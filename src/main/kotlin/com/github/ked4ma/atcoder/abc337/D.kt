package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.array.long.d3.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (H, W, K) = nextIntList()
    val S = times(H) {
        next().toCharArray()
    }.toTypedArray()
    val count1 = sized3DLongArray(H + 1, W + 1, 3, 0L)
    val count2 = sized3DLongArray(H + 1, W + 1, 3, 0L)
    for (i in 1..H) {
        for (j in 1..W) {
            when (S[i - 1][j - 1]) {
                'o' -> {
                    count1[i][j][0]++
                    count2[i][j][0]++
                }

                'x' -> {
                    count1[i][j][1]++
                    count2[i][j][1]++
                }

                '.' -> {
                    count1[i][j][2]++
                    count2[i][j][2]++
                }
            }

            count1[i][j][0] += count1[i][j - 1][0]
            count1[i][j][1] += count1[i][j - 1][1]
            count1[i][j][2] += count1[i][j - 1][2]
            count2[i][j][0] += count2[i - 1][j][0]
            count2[i][j][1] += count2[i - 1][j][1]
            count2[i][j][2] += count2[i - 1][j][2]
        }
    }
    count1.forEach {
        _debug_println(it.map { it[0] }.joinToString(","))
    }
    count2.forEach {
        _debug_println(it.map { it[0] }.joinToString(","))
    }
    var ans = Long.MAX_VALUE
    for (i in 1..H) {
        for (j in 1..W) {
            if (j >= K && count1[i][j][1] - count1[i][j - K][1] == 0L) {
                ans = min(ans, K - (count1[i][j][0] - count1[i][j - K][0]))
            }
            if (i >= K && count2[i][j][1] - count2[i - K][j][1] == 0L) {
                ans = min(ans, K - (count2[i][j][0] - count2[i - K][j][0]))
            }
        }
    }
    println(if (ans == Long.MAX_VALUE) -1 else ans)
}