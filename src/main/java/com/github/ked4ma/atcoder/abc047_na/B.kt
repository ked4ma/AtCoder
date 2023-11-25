package com.github.ked4ma.atcoder.abc047_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (w, h, n) = nextIntList()
    var xs = 0
    var xe = w
    var ys = 0
    var ye = h

    repeat(n) {
        val (x, y, a) = nextIntList()
        when (a) {
            1 -> {
                xs = max(xs, x)
            }

            2 -> {
                xe = min(xe, x)
            }

            3 -> {
                ys = max(ys, y)
            }

            4 -> {
                ye = min(ye, y)
            }
        }
    }
    println(xe.minus(xs).coerceAtLeast(0) * ye.minus(ys).coerceAtLeast(0))
}
