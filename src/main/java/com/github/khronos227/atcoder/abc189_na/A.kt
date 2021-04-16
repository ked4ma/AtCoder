package com.github.khronos227.atcoder.abc189_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val c = next().toCharArray().toSet()
    _debug_println(c)
    println(if (c.size == 1) "Won" else "Lost")
}
