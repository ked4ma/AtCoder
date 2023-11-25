package com.github.ked4ma.atcoder.abc194_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val N = nextLong()
    var res = 0.0
    (N - 1 downTo 1).forEach { n ->
        res += N.toDouble() / n
    }
    println(res)
}
