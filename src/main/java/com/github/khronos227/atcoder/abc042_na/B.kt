package com.github.khronos227.atcoder.abc042_na

fun main() {
    val (n, l) = nextIntList()
    println((0 until n).map {
        next()
    }.sorted().joinToString(separator = ""))
}
