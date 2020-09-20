package com.github.khronos227.atcoder.abc178

import kotlin.math.max

fun main() {
    val w = mutableListOf<Long>()
    val z = mutableListOf<Long>()
    val n = nextInt()
    repeat(n) {
        val (x, y) = nextLongList()
        w.add(x + y)
        z.add(x - y)
    }
    println(
        max(
            (w.max() ?: 0) - (w.min() ?: 0),
            (z.max() ?: 0) - (z.min() ?: 0)
        )
    )
}
