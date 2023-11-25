package com.github.ked4ma.atcoder.abc203_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val (n, k) = nextIntList()
    var total = 0
    total += ((k + 1) * k / 2) * n
    total += ((n + 1) * n / 2) * k * 100
    println(total)
}
