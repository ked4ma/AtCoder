package com.github.ked4ma.atcoder.abc046_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val s = next()
    val p = s.filter { it == 'p' }.length
    println(s.length / 2 - p)
}
