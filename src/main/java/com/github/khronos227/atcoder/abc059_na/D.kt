package com.github.khronos227.atcoder.abc059_na

import com.github.khronos227.atcoder.utils.*
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
