package com.github.khronos227.atcoder.abc184

fun main() {
    val (n, x) = nextIntList()
    var ans = x
    next().forEach {
        when (it) {
            'o' -> ans++
            else -> ans = (ans - 1).coerceAtLeast(0)
        }
    }
    println(ans)
}
