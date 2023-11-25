package com.github.ked4ma.atcoder.abc188

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.abs

fun main() {
    val (A, B) = nextIntList()
    println(if (abs(A - B) < 3) "Yes" else "No")
}
