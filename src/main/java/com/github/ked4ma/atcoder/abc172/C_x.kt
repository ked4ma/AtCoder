package com.github.ked4ma.atcoder.abc172

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    val (N, M, K) = nextIntList()
    val aList = nextIntList()
    val bList = nextIntList()

    val aSumList = sizedArray(N + 1, 0L)
    aList.forEachIndexed { index, i ->
        aSumList[index + 1] = aSumList[index] + i
    }
    val bSumList = sizedArray(M + 1, 0L)
    bList.forEachIndexed { index, i ->
        bSumList[index + 1] = bSumList[index] + i
    }

    var res = 0
    var bIndex = M
    run {
        aSumList.forEachIndexed { index, a ->
            if (a > K) return@run
            while (a + bSumList[bIndex] > K) {
                bIndex--
            }
            res = max(res, index + bIndex)
        }
    }
    println(res)
}
