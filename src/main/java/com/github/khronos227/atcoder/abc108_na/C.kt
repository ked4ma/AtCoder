package com.github.khronos227.atcoder.abc108_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (N, K) = nextIntList()

    val k0 = (N / K).toLong()
    val k1 = ((N + K / 2) / K).toLong()

    if (K % 2 == 0) {
        println(k0 * k0 * k0 + k1 * k1 * k1)
    } else {
        println(k0 * k0 * k0)
    }
}
