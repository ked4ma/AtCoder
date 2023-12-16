package com.github.ked4ma.atcoder.abc061_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (a, b, c) = nextIntList()
    println(if (c in a..b) "Yes" else "No")
}
