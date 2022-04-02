package com.github.ked4ma.atcoder.abc181

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val n = nextInt()
    var sum = 0L
    repeat(n) {
        val (a, b) = nextLongList()
        sum += (a + b) * (b - a + 1) / 2
    }
    println(sum)
}
