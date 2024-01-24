package com.github.ked4ma.atcoder.abc182

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    val n = nextInt()
    val a = nextLongList()
    val sumA = sizedArray(n, 0L)
    val maxA = sizedArray(n, 0L)

    sumA[0] = a[0]
    for (i in 1 until a.size) {
        sumA[i] = sumA[i - 1] + a[i]
    }

    var tmpMax = 0L
    for (i in a.indices) {
        tmpMax = max(tmpMax, sumA[i])
        maxA[i] = tmpMax
    }

//    println(sumA.joinToString(","))
//    println(maxA.joinToString(","))

    var result = 0L
    var x = 0L
    for (i in a.indices) {
        result = max(result, x + maxA[i])
        x += sumA[i]
    }
    println(result)
}
