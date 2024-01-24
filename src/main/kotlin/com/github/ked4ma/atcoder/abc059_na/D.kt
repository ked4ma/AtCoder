package com.github.ked4ma.atcoder.abc059_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs

fun main() {
    val (x, y) = nextLongList()
    println(
        if (abs(x - y) <= 1) {
            "Brown"
        } else {
            "Alice"
        }
    )
}
