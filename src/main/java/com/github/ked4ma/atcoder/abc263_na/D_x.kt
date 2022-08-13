package com.github.ked4ma.atcoder.abc263_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.min

fun main() {
    val (N, L, R) = nextLongList().let { (N, L, R) -> Triple(N.toInt(), L, R) }
    val A = nextLongList().toLongArray()

    val dpL = sizedArray(N + 1, 0L)
    val dpR = sizedArray(N + 1, 0L)
    for (i in 1..N) {
        dpL[i] = min(dpL[i - 1] + A[i - 1], L * i)
        dpR[i] = min(dpR[i - 1] + A[N - i], R * i)
    }
    var result = Long.MAX_VALUE
    for (i in 0..N) {
        result = min(result, dpL[i] + dpR[N - i])
    }

    _debug_println(dpL.toList())
    _debug_println(dpR.toList())
    println(result)
}
