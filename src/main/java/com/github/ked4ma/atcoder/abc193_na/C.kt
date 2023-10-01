package com.github.ked4ma.atcoder.abc193_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val N = nextLong()

    var a = 2L
    var n = a * a
    val creatable = mutableSetOf<Long>()

    while (n <= N) {
        while (n <= N) {
            creatable.add(n)
            n *= a
        }
        a++
        n = a * a
    }
    println(N - creatable.size)
}
