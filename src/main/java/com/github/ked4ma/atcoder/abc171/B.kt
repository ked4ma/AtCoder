package com.github.ked4ma.atcoder.abc171

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (_, k) = nextIntList()
    val prices = nextIntList().sorted()
    println(prices.subList(0, k).sum())
}
