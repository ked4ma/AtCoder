package com.github.ked4ma.atcoder.abc047_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (a, b, c) = nextIntList().sorted()
    println(if (a + b == c) "Yes" else "No")
}
