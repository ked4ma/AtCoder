package com.github.ked4ma.atcoder.abc048_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (a, b, x) = nextLongList()
    println(b / x + if (a == 0L) 1 else -(a - 1) / x)
}
