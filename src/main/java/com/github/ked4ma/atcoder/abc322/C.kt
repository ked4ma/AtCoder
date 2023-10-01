package com.github.ked4ma.atcoder.abc322

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    var index = 0
    (1..N).forEach { i ->
        println(A[index] - i)
        if (i == A[index]) {
            index++
        }
    }
}