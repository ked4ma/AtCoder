package com.github.ked4ma.atcoder.abc184

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (_, x) = nextIntList()
    var ans = x
    next().forEach {
        when (it) {
            'o' -> ans++
            else -> ans = (ans - 1).coerceAtLeast(0)
        }
    }
    println(ans)
}
