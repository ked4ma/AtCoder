package com.github.khronos227.atcoder.abc195_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (M, H) = nextIntList()
    println(if (H % M == 0) "Yes" else "No")
}
