package com.github.khronos227.atcoder.abc105_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (n, k) = nextIntList()
    println(if (n % k == 0) 0 else 1)
}
