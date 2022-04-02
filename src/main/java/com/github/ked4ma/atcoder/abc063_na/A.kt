package com.github.ked4ma.atcoder.abc063_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (a, b) = nextIntList()
    val v = a + b
    println(
        if (v >= 10) {
            "error"
        } else {
            v
        }
    )
}
