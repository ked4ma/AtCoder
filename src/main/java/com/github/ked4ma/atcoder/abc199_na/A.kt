package com.github.ked4ma.atcoder.abc199_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (A, B, C) = nextIntList()
    println(if (A * A + B * B < C * C) "Yes" else "No")
}
