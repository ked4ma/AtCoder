package com.github.ked4ma.atcoder.abc048_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val s = next()
    println(if ((s.length % 2 == 0) xor (s.first() == s.last())) "Second" else "First")
}
