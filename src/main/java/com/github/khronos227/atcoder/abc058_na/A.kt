package com.github.khronos227.atcoder.abc058_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (a, b, c) = nextIntList()
    println(if (b - a == c - b) "YES" else "NO")
}
