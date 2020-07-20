package com.github.khronos227.atcoder.abc169

fun main() {
    val (a, b) = nextList()
    println(a.toLong().times(b.replace(".", "", true).toLong()).div(100))
}
