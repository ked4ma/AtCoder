package com.github.ked4ma.atcoder.abc061_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (n, k) = nextLongList()
    val data = (0 until n).map {
        val (a, b) = nextLongList()
        a to b
    }.sortedBy { it.first }
    var c = 0L
    var index = -1
    while (c < k && index <= data.lastIndex) {
        index++
        c += data[index].second
    }
    println(data[index].first)
}
