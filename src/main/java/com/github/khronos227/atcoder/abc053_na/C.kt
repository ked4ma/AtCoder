package com.github.khronos227.atcoder.abc053_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val x = nextLong()
    val loop = x / 11
    val adjust = when {
        x % 11 == 0L -> 0
        x % 11 > 6L -> 2
        else -> 1
    }
    println(2 * loop + adjust)
}
