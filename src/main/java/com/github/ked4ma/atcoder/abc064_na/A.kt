package com.github.ked4ma.atcoder.abc064_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (r, g, b) = nextIntList()
    println(if ((r * 100 + g * 10 + b) % 4 == 0) "YES" else "NO")
}
