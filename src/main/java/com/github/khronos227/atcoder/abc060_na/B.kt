package com.github.khronos227.atcoder.abc060_na

fun main() {
    val (a, b, c) = nextIntList()
    println(
        if (
            (1..b).any {
                (a * it) % b == c
            }
        ) "YES" else "NO"
    )
}
