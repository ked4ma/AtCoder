package com.github.khronos227.atcoder.abc063_na

import com.github.khronos227.atcoder.utils.*

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
