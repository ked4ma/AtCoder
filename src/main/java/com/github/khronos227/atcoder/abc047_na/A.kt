package com.github.khronos227.atcoder.abc047_na

fun main() {
    val (a, b, c) = nextIntList().sorted()
    println(if (a + b == c) "Yes" else "No")
}
