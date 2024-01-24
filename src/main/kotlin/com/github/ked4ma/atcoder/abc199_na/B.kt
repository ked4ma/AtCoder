package com.github.ked4ma.atcoder.abc199_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max

fun main() {
    next() // N
    val A = nextIntList()
    val B = nextIntList()
    println(max(0, (B.min() ?: 0) - (A.max() ?: 0) + 1))
}
