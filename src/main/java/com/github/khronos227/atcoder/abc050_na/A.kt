package com.github.khronos227.atcoder.abc050_na

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
