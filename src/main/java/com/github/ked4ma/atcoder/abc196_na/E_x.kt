package com.github.ked4ma.atcoder.abc196_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    var high = Double.POSITIVE_INFINITY
    var low = Double.NEGATIVE_INFINITY
    var add = 0L

    repeat(nextInt()) {
        val (a, t) = nextLongList()
        _debug_println("a: $a, t: $t")
        when (t) {
            1L -> {
                high += a
                low += a
                add += a
            }
            2L -> {
                low = max(low, a.toDouble())
                high = max(low, high)
            }
            3L -> {
                high = min(high, a.toDouble())
                low = min(low, high)
            }
        }
        _debug_println("add: $add, high: $high, low: $low")
    }
    nextInt()
    nextLongList().forEach { q ->
        println(
            if (q + add < low) {
                low.toLong()
            } else if (q + add > high) {
                high.toLong()
            } else {
                q + add
            }
        )
    }
    _debug_println(high)
    _debug_println(low)
}


fun main_lte() {
    val atList = (0 until nextInt()).map {
        nextLongList().let { it[0] to it[1].toInt() }
    }

    data class Result(var value: Long = 0L)

    val dp = emptyMap<Triple<Int, Long, Int>, Result>().toMutableMap()
    nextLong()
    for (q in nextLongList()) {
        val result = Result()
        var x = q
        for (i in atList.indices) {
            val (a, t) = atList[i]
            if (Triple(i, x, t) in dp) {
                _debug_println("found in cache")
                x = dp.getValue(Triple(i, x, t)).value
                break
            }
            dp[Triple(i, x, t)] = result
            x = when (t) {
                1 -> x + a
                2 -> max(x, a)
                else -> min(x, a)
            }
        }
        result.value = x
        _debug_print("[$q]: ")
        println(x)
    }
}
