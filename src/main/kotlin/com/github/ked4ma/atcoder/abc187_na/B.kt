package com.github.ked4ma.atcoder.abc187_na

import com.github.ked4ma.atcoder.utils.input.deprecated.*
import kotlin.math.abs

fun main() {
    val n = nextInt()
    val points = (1..n).map {
        val (x, y) = nextIntList()
        x to y
    }.sortedBy { it.first }

    var ans = 0
    for (i in 0 until n - 1) {
        val (x1, y1) = points[i]
        for (j in i + 1 until n) {
            val (x2, y2) = points[j]
            if (abs(y1 - y2) <= abs(x1 - x2)) {
                ans++
            }
        }
    }
    println(ans)
}
