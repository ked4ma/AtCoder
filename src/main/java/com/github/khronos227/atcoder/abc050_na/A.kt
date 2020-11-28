package com.github.khronos227.atcoder.abc050_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (A, op, B) = nextList()
    val a = A.toInt()
    val b = B.toInt()
    println(
        when (op) {
            "+" -> a + b
            else -> a - b
        }
    )
}
