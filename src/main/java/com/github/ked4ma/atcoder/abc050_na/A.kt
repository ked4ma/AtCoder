package com.github.ked4ma.atcoder.abc050_na

import com.github.ked4ma.atcoder.utils.*

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
