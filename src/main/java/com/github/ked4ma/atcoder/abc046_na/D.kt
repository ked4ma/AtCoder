package com.github.ked4ma.atcoder.abc046_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val s = next()
    val p = s.filter { it == 'p' }.length
    println(s.length / 2 - p)
}
