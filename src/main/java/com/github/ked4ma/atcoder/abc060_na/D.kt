package com.github.ked4ma.atcoder.abc060_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.list.*
import kotlin.math.max

fun main() {
    val (n, W) = nextLongList().let { (n, w) -> n.toInt() to w }
    val (wi, vi) = nextLongList()
    val (v0, v1, v2, v3) = {
        val v0 = mutableListOf<Long>()
        val v1 = mutableListOf<Long>()
        val v2 = mutableListOf<Long>()
        val v3 = mutableListOf<Long>()
        v0.add(vi)
        repeat(n - 1) {
            val (w, v) = nextLongList()
            when ((w - wi) % 4) {
                1L -> v1
                2L -> v2
                3L -> v3
                else -> v0
            }.add(v)
        }
        listOf(v0, v1, v2, v3).map { it.sortedDescending() }
    }().map { it.cumulativeSum() }

    var ans = 0L
    for (i0 in v0.indices) {
        val w0 = i0 * wi
        if (w0 > W) break
        for (i1 in v1.indices) {
            val w1 = i1 * (wi + 1) + w0
            if (w1 > W) break
            for (i2 in v2.indices) {
                val w2 = i2 * (wi + 2) + w1
                if (w2 > W) break
                for (i3 in v3.indices) {
                    val w3 = i3 * (wi + 3) + w2
                    if (w3 > W) break
                    ans = max(ans, v0[i0] + v1[i1] + v2[i2] + v3[i3])
                }
            }
        }
    }
    println(ans)
}
