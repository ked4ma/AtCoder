package com.github.khronos227.atcoder.abc048_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (a, b, x) = nextLongList()
    println(b / x + if (a == 0L) 1 else -(a - 1) / x)
}
