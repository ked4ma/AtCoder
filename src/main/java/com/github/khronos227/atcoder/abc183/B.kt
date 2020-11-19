package com.github.khronos227.atcoder.abc183

fun main() {
    val (x1, y1, x2, y2) = nextLongList()
    println((y1 * (x2 - x1) + x1 * (y2 + y1)).toDouble() / (y2 + y1))
}
