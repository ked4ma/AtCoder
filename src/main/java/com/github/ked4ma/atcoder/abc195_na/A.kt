package com.github.ked4ma.atcoder.abc195_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (M, H) = nextIntList()
    println(if (H % M == 0) "Yes" else "No")
}
