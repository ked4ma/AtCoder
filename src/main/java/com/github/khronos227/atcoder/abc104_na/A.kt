package com.github.khronos227.atcoder.abc104_na

fun main() {
    val r = nextInt()
    println(when {
        r < 1200 -> "ABC"
        r < 2800 -> "ARC"
        else -> "AGC"
    })
}
