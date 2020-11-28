package com.github.khronos227.atcoder.abc042_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (n, _) = nextIntList()
    println((0 until n).map {
        next()
    }.sorted().joinToString(separator = ""))
}
