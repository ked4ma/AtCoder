package com.github.khronos227.atcoder.abc101_na

import kotlin.math.ceil

fun main() {
    val (n, k) = nextIntList()
    println(ceil(n.minus(1).toDouble().div(k - 1)).toInt())
}
