package com.github.ked4ma.atcoder.abc189_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val c = next().toCharArray().toSet()
    _debug_println(c)
    println(if (c.size == 1) "Won" else "Lost")
}
