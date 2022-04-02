package com.github.ked4ma.atcoder.abc064_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val colors = listOf(
        1 until 400,
        400 until 800,
        800 until 1200,
        1200 until 1600,
        1600 until 2000,
        2000 until 2400,
        2400 until 2800,
        2800 until 3200
    )

    var freeCount = 0
    nextInt()
    val s = nextIntList().mapNotNull { rate ->
        val index = colors.indexOfFirst { rate in it }
        if (index == -1) {
            freeCount++
            null
        } else {
            index
        }
    }.toSet()
    println("${s.size.coerceAtLeast(1)} ${s.size + freeCount}")
}
