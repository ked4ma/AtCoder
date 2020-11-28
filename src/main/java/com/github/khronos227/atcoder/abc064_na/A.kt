package com.github.khronos227.atcoder.abc064_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (r, g, b) = nextIntList()
    println(if ((r * 100 + g * 10 + b) % 4 == 0) "YES" else "NO")
}
