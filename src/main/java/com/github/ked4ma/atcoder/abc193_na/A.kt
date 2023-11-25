package com.github.ked4ma.atcoder.abc193_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (A, B) = nextIntList()
    println("%.8f".format((1.0 - (B.toDouble() / A)) * 100))
}
