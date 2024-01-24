package com.github.ked4ma.atcoder.abc264_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (L, R) = nextIntList().let { (L, R) -> L - 1 to R - 1 }
    println("atcoder".substring(L..R))
}
