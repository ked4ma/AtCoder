package com.github.ked4ma.atcoder.abc063_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val s = next().toCharArray()
    println(
        if (s.size == s.toSet().size) {
            "yes"
        } else {
            "no"
        }
    )
}
