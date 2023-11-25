package com.github.ked4ma.atcoder.abc054_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    var (a, b) = nextIntList()
    if (a == 1) a = 14
    if (b == 1) b = 14
    println(
        when {
            a == b -> "Draw"
            a > b -> "Alice"
            else -> "Bob"
        }
    )
}
