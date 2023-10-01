package com.github.ked4ma.atcoder.abc100_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.pow

fun main() {
    val (d, n) = nextIntList()
    val m = if (n == 100) {
        n + 1
    } else {
        n
    }
    println(m * 100.toDouble().pow(d).toInt())
}
