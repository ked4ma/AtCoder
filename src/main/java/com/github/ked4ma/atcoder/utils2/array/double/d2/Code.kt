package com.github.ked4ma.atcoder.utils2.array.double.d2

import com.github.ked4ma.atcoder.utils.debug.*

fun sized2DDoubleArray(row: Long, col: Long, default: Double): Array<DoubleArray> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { DoubleArray(col.toInt()) { default } }
}

fun sized2DDoubleArray(row: Long, col: Long, default: () -> Double): Array<DoubleArray> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { DoubleArray(col.toInt()) { default.invoke() } }
}
