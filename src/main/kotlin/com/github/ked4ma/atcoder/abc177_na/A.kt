package com.github.ked4ma.atcoder.abc177_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val (d, t, s) = nextIntList()
    println(if (t * s >= d) "Yes" else "No")
}
