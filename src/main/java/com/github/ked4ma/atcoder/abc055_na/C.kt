package com.github.ked4ma.atcoder.abc055_na

import com.github.ked4ma.atcoder.utils.input.default.*

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
