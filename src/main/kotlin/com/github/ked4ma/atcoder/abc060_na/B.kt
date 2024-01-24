package com.github.ked4ma.atcoder.abc060_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (a, b, c) = nextIntList()
    println(
        if (
            (1..b).any {
                (a * it) % b == c
            }
        ) "YES" else "NO"
    )
}
