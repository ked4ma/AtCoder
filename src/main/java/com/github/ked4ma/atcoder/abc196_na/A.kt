package com.github.ked4ma.atcoder.abc196_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val x = nextIntList().max()!!
    val y = nextIntList().min()!!
    println(x - y)
}
