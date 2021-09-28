package com.github.khronos227.atcoder.abc193_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (A, B) = nextIntList()
    println("%.8f".format((1.0 - (B.toDouble() / A)) * 100))
}
