package com.github.ked4ma.atcoder.abc042_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (n, _) = nextIntList()
    println((0 until n).map {
        next()
    }.sorted().joinToString(separator = ""))
}