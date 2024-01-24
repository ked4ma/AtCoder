package com.github.ked4ma.atcoder.abc202_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val mapping = mapOf(
        '0' to '0',
        '1' to '1',
        '6' to '9',
        '8' to '8',
        '9' to '6'
    )
    println(
        buildString {
            for (c in next()) {
                insert(0, mapping[c])
            }
        }
    )
}
