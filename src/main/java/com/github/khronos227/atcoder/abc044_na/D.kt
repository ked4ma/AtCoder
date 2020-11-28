package com.github.khronos227.atcoder.abc044_na

import com.github.khronos227.atcoder.utils.*
import kotlin.math.sqrt

fun main() {
    val n = nextLong()
    val s = nextLong()
    fun f(b: Long, n: Long): Long {
        if (n < b) return n
        return f(b, n / b) + n.rem(b)
    }
    if (n == s) {
        println(n + 1)
        return
    }
    (2L..sqrt(n.toDouble()).toLong()).forEach {
        if (f(it, n) == s) {
            println(it)
            return
        }
    }
    (sqrt(n.toDouble()).toLong() downTo 1L).forEach {
        val b = n.minus(s).div(it) + 1
        if (b < 2) return@forEach
        if (f(b, n) == s) {
            println(b)
            return
        }
    }
    println(-1)
}
