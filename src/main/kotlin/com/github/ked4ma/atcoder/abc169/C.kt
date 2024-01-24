package com.github.ked4ma.atcoder.abc169

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (a, b) = nextList()
    println(a.toLong().times(b.replace(".", "", true).toLong()).div(100))
}
