package com.github.khronos227.atcoder.abc063_na

fun main() {
    val (a, b) = nextIntList()
    val v = a + b
    println(
        if (v >= 10) {
            "error"
        } else {
            v
        }
    )
}
