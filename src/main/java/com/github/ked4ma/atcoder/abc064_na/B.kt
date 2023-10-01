package com.github.ked4ma.atcoder.abc064_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    nextInt()
    println(nextIntList().sorted().let { it.last() - it.first() })
}
