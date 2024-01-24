package com.github.ked4ma.atcoder.abc193_na

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.pow

fun main() {
    val K = nextLong()
    val remains = sizedArray(10, K)
    val S = sizedArray(10, 0)
    val T = sizedArray(10, 0)
    next().substring(0, 4).map {
        val n = it.toInt() - 48
        S[n]++
        remains[n]--
    }
    next().substring(0, 4).map {
        val n = it.toInt() - 48
        T[n]++
        remains[n]--
    }
    fun point(arr: Array<Int>) = arr.mapIndexed { i, n -> i * (10.0.pow(n)) }.sum()
    val sp = point(S)
    val tp = point(T)
    var win = 0L
    _debug_println(remains.toList())
    (1..9).forEach { a ->
        if (remains[a] == 0L) return@forEach
        val ssp = sp - (a * (10.0.pow(S[a]))) + (a * 10.0.pow(S[a] + 1))

        (1..9).forEach { b ->
            val ttp = tp - (b * 10.0.pow(T[b])) + (b * 10.0.pow(T[b] + 1))
            if (a == b) {
                if (remains[b] < 2) return@forEach
                if (ssp > ttp) {
                    win += remains[a] * (remains[b] - 1)
                }
            } else {
                if (remains[b] == 0L) return@forEach
                if (ssp > ttp) {
                    win += remains[a] * remains[b]
                }
            }
        }
    }
    val count = (9L * K - 8) * (9L * K - 9)
    _debug_println(win)
    _debug_println(count)
    println(win.toDouble() / count)
}
