package com.github.ked4ma.atcoder.abc062_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val (h, w) = nextLongList()
    var ans = Long.MAX_VALUE

    fun div2(h: Long, w: Long): Pair<Long, Long> {
        val halfH = h / 2
        val halfW = w / 2
        val (ah, bh) = halfH * w to (h - halfH) * w
        val (aw, bw) = h * halfW to h * (w - halfW)
        return if (abs(ah - bh) < abs(aw - bw)) {
            ah to bh
        } else {
            aw to bw
        }
    }

    for (i in (1..h / 2)) {
        val a = i * w
        val (b, c) = div2(h - i, w)

        ans = min(ans, maxOf(a, b, c) - minOf(a, b, c))
    }

    for (j in (1..w / 2)) {
        val a = j * h
        val (b, c) = div2(h, w - j)

        ans = min(ans, maxOf(a, b, c) - minOf(a, b, c))
    }

    println(ans)
}
