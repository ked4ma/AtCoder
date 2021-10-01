package com.github.khronos227.atcoder.abc194_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (A, B) = nextIntList()
    val type = when {
        A + B >= 15 && B >=8 -> 1
        A + B >= 10 && B >= 3 -> 2
        A + B >= 3 -> 3
        else -> 4
    }
    println(type)
}
