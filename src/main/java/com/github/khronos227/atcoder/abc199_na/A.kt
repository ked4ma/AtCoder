package com.github.khronos227.atcoder.abc199_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (A, B, C) = nextIntList()
    println(if (A * A + B * B < C * C) "Yes" else "No")
}
