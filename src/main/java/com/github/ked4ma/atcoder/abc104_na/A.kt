package com.github.ked4ma.atcoder.abc104_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val r = nextInt()
    println(
        when {
            r < 1200 -> "ABC"
            r < 2800 -> "ARC"
            else -> "AGC"
        }
    )
}
