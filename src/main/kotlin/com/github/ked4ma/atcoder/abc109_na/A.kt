package com.github.ked4ma.atcoder.abc109_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (A, B) = nextIntList()
    println(
        if ((A * B) % 2 == 1) {
            "Yes"
        } else {
            "No"
        }
    )
}
