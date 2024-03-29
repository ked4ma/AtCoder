package com.github.ked4ma.atcoder.arc104

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (nStr, s) = nextList()
    val n = nStr.toInt()
    val atCnt = sizedArray(n + 1, 0)
    val cgCnt = sizedArray(n + 1, 0)

    s.forEachIndexed { index, c ->
        when (c) {
            'A' -> atCnt[index + 1] = 1
            'T' -> atCnt[index + 1] = -1
            'C' -> cgCnt[index + 1] = 1
            'G' -> cgCnt[index + 1] = -1
        }
    }
    (1..n).forEach {
        atCnt[it] += atCnt[it - 1]
        cgCnt[it] += cgCnt[it - 1]
    }

    var cnt = 0
    (0 until n).forEach { i ->
        ((i + 2)..n step 2).forEach { j ->
            if ((atCnt[j] - atCnt[i]) == 0 && (cgCnt[j] - cgCnt[i]) == 0) cnt++
        }
    }
    println(cnt)
}
