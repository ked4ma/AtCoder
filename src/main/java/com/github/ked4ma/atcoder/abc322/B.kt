package com.github.ked4ma.atcoder.abc322

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (N, M) = nextIntList()
    val S = next()
    val T = next()
    val start = T.startsWith(S)
    val end = T.endsWith(S)
    println(
        if (start && end) {
            0
        } else if (start && !end) {
            1
        } else if (!start && end) {
            2
        } else {
            3
        }
    )
}