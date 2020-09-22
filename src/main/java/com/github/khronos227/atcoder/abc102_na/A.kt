package com.github.khronos227.atcoder.abc102_na

fun main() {
    val n = nextLong()
    println(
        if (n % 2 == 0L) {
            n
        } else {
            2 * n
        }
    )
}
