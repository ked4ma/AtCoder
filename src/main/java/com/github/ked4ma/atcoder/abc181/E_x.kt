package com.github.ked4ma.atcoder.abc181

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    nextIntList() // n, m
    val h = nextLongList().sorted()
    val w = nextLongList().sorted()
    var ans = Long.MAX_VALUE

    val memo1 = sizedArray(h.size / 2 + 1, 0L)
    for (i in (0 until h.lastIndex step 2)) {
        memo1[i / 2 + 1] = h[i + 1] - h[i] + memo1[i / 2]
    }
    val memo2 = sizedArray(h.size / 2 + 1, 0L)
    for (i in (h.size - 2 downTo 0 step 2)) {
        memo2[i / 2] = h[i + 1] - h[i] + memo2[i / 2 + 1]
    }

    var index = 0
    for (t in w) {
        while (index < h.size && t > h[index]) index++
        val i = if (index and 1 == 1) {
            index xor 1
        } else {
            index
        }
        val sum = memo1[index / 2] + abs(h[i] - t) + memo2[index / 2]
        ans = min(ans, sum)
    }

    println(ans)
}
