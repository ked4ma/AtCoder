package com.github.ked4ma.atcoder.abc063_na

import com.github.ked4ma.atcoder.utils.*

// binary search
fun main() {
    val (n, a, b) = nextLongList().let { (n, a, b) ->
        Triple(n.toInt(), a, b)
    }
    val c = a - b
    val h = (0 until n).map {
        nextLong()
    }

    fun enough(t: Long): Boolean {
        val bt = b * t
        val x = h.map { it - bt }.filter { it > 0 }.map {
            it / c + if (it % c == 0L) 0 else 1
        }.sum()
        return x <= t
    }

    var l = 0L
    var r = 2_000_000_000L

    while (l < r) {
        val mid = (l + r) / 2
        if (enough(mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    println(l)
}
