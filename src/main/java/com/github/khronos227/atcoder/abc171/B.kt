package com.github.khronos227.atcoder.abc171

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (_, k) = nextIntList()
    val prices = nextIntList().sorted()
    println(prices.subList(0, k).sum())
}
