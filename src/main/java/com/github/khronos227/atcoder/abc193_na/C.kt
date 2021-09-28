package com.github.khronos227.atcoder.abc193_na

import com.github.khronos227.atcoder.utils.*

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
