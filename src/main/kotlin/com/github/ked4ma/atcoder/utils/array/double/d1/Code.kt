package com.github.ked4ma.atcoder.utils.array.double.d1

import com.github.ked4ma.atcoder.utils.debug.*

fun sizedDoubleArray(row: Long, default: Double): DoubleArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return DoubleArray(row.toInt()) { default }
}

fun sizedDoubleArray(row: Long, default: () -> Double): DoubleArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return DoubleArray(row.toInt()) { default.invoke() }
}
