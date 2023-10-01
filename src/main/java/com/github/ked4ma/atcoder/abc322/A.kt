package com.github.ked4ma.atcoder.abc322

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    next()
    val S = next()
    println(S.indexOf("ABC").let { if (it < 0) it else it + 1 })
}