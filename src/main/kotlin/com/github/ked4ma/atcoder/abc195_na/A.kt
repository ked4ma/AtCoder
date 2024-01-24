package com.github.ked4ma.atcoder.abc195_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (M, H) = nextIntList()
    println(if (H % M == 0) "Yes" else "No")
}
