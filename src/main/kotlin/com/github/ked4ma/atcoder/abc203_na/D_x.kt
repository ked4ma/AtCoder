package com.github.ked4ma.atcoder.abc203_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import com.github.ked4ma.atcoder.utils.models.cumlative.d2sum.*

fun main() {
    val (n, k) = nextIntList()
    val arr = (0 until n).map {
        nextIntList()
    }

    val cumsum2d = CumulativeSum2D(arr.size, arr.first().size)

    // judge lim can be more greater value
    fun check(lim: Int): Boolean {
        arr.forEachIndexed { h, col ->
            col.forEachIndexed { w, n ->
                cumsum2d.set(h, w, if (lim <= n) 1 else 0)
            }
        }
        cumsum2d.build()
        for (i in 0..n - k) {
            for (j in 0..n - k) {
                // count of numbers that are greater than or equal mid
                val count = cumsum2d.getSumOf(i, j, i + k - 1, j + k - 1)
                if (count < k * k / 2 + 1) return false
            }
        }
        return true
    }

    var l = 0
    var r = Int.MAX_VALUE
    while (l + 1 < r) {
        val mid = (l + r) / 2
        if (check(mid)) {
            l = mid
        } else {
            r = mid
        }
    }
    println(l)
}
