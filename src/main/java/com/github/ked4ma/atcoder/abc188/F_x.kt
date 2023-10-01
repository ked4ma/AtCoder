package com.github.ked4ma.atcoder.abc188

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val (X, Y) = nextLongList()
    val memo = mutableMapOf<Long, Long>()
    fun solve(y: Long): Long {
        return memo[y] ?: when {
            y == 1L -> abs(X - y)
            y % 2 == 0L -> min(abs(X - y), solve(y / 2) + 1)
            else -> minOf(abs(X - y), solve((y + 1) / 2) + 2, solve((y - 1) / 2) + 2)
        }.also{
            memo[y] = it
        }
    }
    println(solve(Y))
    _debug_println(memo)
}
