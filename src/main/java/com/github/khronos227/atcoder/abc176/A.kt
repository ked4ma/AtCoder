package com.github.khronos227.atcoder.abc176

import kotlin.math.ceil

fun main() {
    val (n, x, t) = nextIntList()
    println(ceil(n.toDouble().div(x)).toInt().times(t))
}
