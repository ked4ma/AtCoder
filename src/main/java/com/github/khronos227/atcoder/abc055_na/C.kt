package com.github.khronos227.atcoder.abc055_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (n, m) = nextLongList()
    println(
        if (2 * n >= m) {
            m / 2
        } else {
            n + (m - 2 * n) / 4
        }
    )
}
