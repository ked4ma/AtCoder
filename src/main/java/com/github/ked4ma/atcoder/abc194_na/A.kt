package com.github.ked4ma.atcoder.abc194_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (A, B) = nextIntList()
    val type = when {
        A + B >= 15 && B >= 8 -> 1
        A + B >= 10 && B >= 3 -> 2
        A + B >= 3 -> 3
        else -> 4
    }
    println(type)
}
