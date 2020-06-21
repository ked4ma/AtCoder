package com.github.khronos227.atcoder.abc171

fun main() {
    val (n, k) = nextIntList()
    val prices = nextIntList().sorted()
    println(prices.subList(0, k).sum())
}
