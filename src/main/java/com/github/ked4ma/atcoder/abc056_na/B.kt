package com.github.ked4ma.atcoder.abc056_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.abs

fun main() {
    val (w, a, b) = nextIntList()
    println((abs(a - b) - w).coerceAtLeast(0))
}
