package com.github.ked4ma.atcoder.abc101_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val n = nextInt()
    var m = n
    var s = 0
    while (m > 0) {
        s += m % 10
        m /= 10
    }
    println(if (n % s == 0) "Yes" else "No")
}
