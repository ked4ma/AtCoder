package com.github.ked4ma.atcoder.abc176

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = next()
    println(
        if (n.map {
                it.toInt() - 48
            }.sum() % 9 == 0) {
            "Yes"
        } else {
            "No"
        }
    )
}
