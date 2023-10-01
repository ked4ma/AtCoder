package com.github.ked4ma.atcoder.abc103_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val values = nextIntList().sorted()
    println(values.last() - values.first())
}
