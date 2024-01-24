package com.github.ked4ma.atcoder.abc201_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    var first = (0 to "")
    var second = (0 to "")

    repeat(nextInt()) {
        val (name, alt) = nextList().let { (name, alt) -> name to alt.toInt() }
        when {
            alt > first.first -> {
                second = first
                first = alt to name
            }

            alt > second.first -> second = alt to name
        }
    }

    println(second.second)
}
