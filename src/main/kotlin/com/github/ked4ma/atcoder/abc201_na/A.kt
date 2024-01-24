package com.github.ked4ma.atcoder.abc201_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val s = nextIntList().sorted()
    println(if (s.sum() % 3 == 0 && s.sum() == s[1] * 3) "Yes" else "No")
}
