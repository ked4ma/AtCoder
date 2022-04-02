package com.github.ked4ma.atcoder.abc058_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (a, b, c) = nextIntList()
    println(if (b - a == c - b) "YES" else "NO")
}
