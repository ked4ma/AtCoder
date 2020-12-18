package com.github.khronos227.atcoder.abc185

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (n, m, t) = nextIntList()
    var remains = n
    var i = 0
    repeat(m) {
        val (a, b) = nextIntList()
        remains -= a - i
        if (remains <= 0) {
            println("No")
            return
        }
        remains = (remains + b - a).coerceAtMost(n)
        i = b
    }
    remains -= t - i

    println(if (remains <= 0) "No" else "Yes")
}
