package com.github.ked4ma.atcoder.abc178

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (a, b, c, d) = nextLongList()
    println(
        listOf(
            a * c,
            a * d,
            b * c,
            b * d
        ).max()
    )
}
