package com.github.ked4ma.atcoder.abc053_na

import com.github.ked4ma.atcoder.utils.input.default.*

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
