package com.github.khronos227.atcoder.abc194_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextLong()
    var res = 0.0
    (N-1 downTo 1).forEach { n ->
        res += N.toDouble() / n
    }
    println(res)
}
