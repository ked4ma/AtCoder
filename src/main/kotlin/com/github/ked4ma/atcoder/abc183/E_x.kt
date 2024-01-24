package com.github.ked4ma.atcoder.abc183

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.math.mod.*

fun main() {
    val (H, W) = nextIntList()
    val b = (0 until H).map {
        next().toCharArray()
    }
    val dp = sized2DArray(H, W, 0L)
    dp[0][0] = 1L
    val accH = sized2DArray(H, W, 0L)
    val accW = sized2DArray(H, W, 0L)
    val accS = sized2DArray(H, W, 0L)
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (h == 0 && w == 0) continue
            if (b[h][w] == '#') continue
            val i = h - 1
            if (i >= 0 && b[i][w] != '#') {
                accH[h][w] = accH[i][w].plus(dp[i][w], MOD)
            }
            val j = w - 1
            if (j >= 0 && b[h][j] != '#') {
                accW[h][w] = accW[h][j].plus(dp[h][j], MOD)
            }
            if (i >= 0 && j >= 0 && b[i][j] != '#') {
                accS[h][w] = accS[i][j].plus(dp[i][j], MOD)
            }
            dp[h][w] = accH[h][w].plus(accW[h][w], MOD).plus(accS[h][w], MOD)
        }
    }
//    accH.forEach {
//        println(it.joinToString(","))
//    }
//    dp.forEach {
//        println(it.joinToString(","))
//    }
    println(dp.last().last())
}
