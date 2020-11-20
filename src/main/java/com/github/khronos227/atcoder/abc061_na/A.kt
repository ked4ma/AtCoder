package com.github.khronos227.atcoder.abc061_na

fun main() {
    val (a, b, c) = nextIntList()
    println(if (c in a..b) "Yes" else "No")
}
