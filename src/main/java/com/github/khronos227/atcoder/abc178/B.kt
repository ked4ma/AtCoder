package com.github.khronos227.atcoder.abc178

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
