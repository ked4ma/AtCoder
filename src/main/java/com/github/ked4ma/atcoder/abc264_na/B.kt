package com.github.ked4ma.atcoder.abc264_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.abs
import kotlin.math.max

fun main() {
    val (R, C) = nextIntList()
    val bigger = max(abs(R - 8), abs(C - 8))
    println(if (bigger % 2 == 0) "white" else "black")
}
