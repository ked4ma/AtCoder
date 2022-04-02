package com.github.ked4ma.atcoder.abc105_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (n, k) = nextIntList()
    println(if (n % k == 0) 0 else 1)
}
