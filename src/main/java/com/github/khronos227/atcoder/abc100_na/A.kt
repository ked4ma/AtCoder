package com.github.khronos227.atcoder.abc100_na

fun main() {
    val (a, b) = nextIntList()
    println(if (a <= 8 && b <= 8) {
        "Yay!"
    } else {
        ":("
    })
}
