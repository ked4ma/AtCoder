package com.github.khronos227.atcoder.abc184

import com.github.khronos227.atcoder.utils.*

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
