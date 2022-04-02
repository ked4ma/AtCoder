package com.github.ked4ma.atcoder.abc101_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.ceil

fun main() {
    val (n, k) = nextIntList()
    println(ceil(n.minus(1).toDouble().div(k - 1)).toInt())
}
