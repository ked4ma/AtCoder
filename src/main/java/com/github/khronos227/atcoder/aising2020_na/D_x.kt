package com.github.khronos227.atcoder.aising2020_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val x = next().map { (it - 48).toInt() }.toIntArray()
    val popcount = x.filter { it == 1 }.size
    val popcountM = popcount.minus(1).coerceAtLeast(1)
    val popcountP = popcount.plus(1)
    val less = remInt(x, popcount - 1)
    val greater = remInt(x, popcount + 1)
    val lessRems = sizedArray(n, 1.rem(popcountM))
    val greaterRems = sizedArray(n, 1.rem(popcountP))
    (n.minus(2) downTo 0).forEach { index ->
        lessRems[index] = lessRems[index + 1].times(2).rem(popcountM)
        greaterRems[index] = greaterRems[index + 1].times(2).rem(popcountP)
    }

    (0 until n).forEach { index ->
        var count = 1
        var x2 = when {
            x[index] == 0 -> {
                greater.plus(greaterRems[index]).rem(popcountP)
            }
            popcount == 1 -> {
                println(0)
                return@forEach
            }
            else -> {
                less.minus(lessRems[index]).plus(popcountM).rem(popcountM)
            }
        }
        while (x2 > 0) {
            val pc = Integer.toBinaryString(x2).count { it == '1' }
            x2 %= pc
            count += 1
        }
        println(count)
    }
}

private fun remInt(values: IntArray, mod: Int): Int {
    if (mod == 0) return 0
    var operand = 0
    values.forEach { value ->
        operand = operand.shl(1).plus(value).rem(mod)
    }
    return operand
}
