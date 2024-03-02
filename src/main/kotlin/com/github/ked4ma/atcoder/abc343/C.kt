package com.github.ked4ma.atcoder.abc343

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.cbrt
import kotlin.math.ceil

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val N3 = ceil(cbrt(N.toDouble())).toLong()
    _debug_println(N3)
    for (n in N3 downTo 0) {
        val x = (n * n * n).takeIf { it <= N }?.toString() ?: continue
        if ((0 until x.length / 2).all { x[it] == x[x.lastIndex - it] }) {
            println(x)
            return
        }
    }
}