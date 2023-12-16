package com.github.ked4ma.atcoder.abc062_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val group = mutableMapOf(
        *arrayOf(1, 3, 5, 7, 8, 10, 12).map { it to 0 }.toTypedArray(),
        *arrayOf(4, 6, 9, 11).map { it to 1 }.toTypedArray(),
        *arrayOf(2).map { it to 2 }.toTypedArray()
    )

    val (x, y) = nextIntList()
    println(if (group.getValue(x) == group.getValue(y)) "Yes" else "No")
}
