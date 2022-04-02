package com.github.ked4ma.atcoder.abc198_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.sqrt

/**
 * edge case:
 *   input = 2 1 0
 */
fun main() {
    val (R, X, Y) = nextLongList()
    val dist = sqrt((X * X + Y * Y).toDouble())
    println(max(1, floor(dist / R).toLong()) + if (dist % R == 0.0) 0 else 1)
}
