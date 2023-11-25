package com.github.ked4ma.atcoder.abc187_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    val n = nextInt()
    var sumA = 0L
    var sumB = 0L
    val votes = (1..n).map {
        val (a, b) = nextLongList()
        sumA += a
        a to b
    }.sortedByDescending { 2 * it.first + it.second }

    var index = 0
    while (sumA >= sumB) {
        val (a, b) = votes[index]
        sumA -= a
        sumB += a + b
        index++
    }
    println(index)
}
