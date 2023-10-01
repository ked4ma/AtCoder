package com.github.ked4ma.atcoder.abc100_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (a, b) = nextIntList()
    println(
        if (a <= 8 && b <= 8) {
            "Yay!"
        } else {
            ":("
        }
    )
}
