package com.github.ked4ma.atcoder.abc176

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.ceil

fun main() {
    val (n, x, t) = nextIntList()
    println(ceil(n.toDouble().div(x)).toInt().times(t))
}
