package com.github.khronos227.atcoder.abc199_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.max

fun main() {
    next() // N
    val A = nextIntList()
    val B = nextIntList()
    println(max(0, (B.min() ?: 0) - (A.max() ?: 0) + 1))
}
