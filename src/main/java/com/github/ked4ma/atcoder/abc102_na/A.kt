package com.github.ked4ma.atcoder.abc102_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = nextLong()
    println(
        if (n % 2 == 0L) {
            n
        } else {
            2 * n
        }
    )
}
