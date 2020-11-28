package com.github.khronos227.atcoder.abc056_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.abs

fun main() {
    val (w, a, b) = nextIntList()
    println((abs(a - b) - w).coerceAtLeast(0))
}
