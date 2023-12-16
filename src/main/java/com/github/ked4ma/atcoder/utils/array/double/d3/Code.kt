package com.github.ked4ma.atcoder.utils.array.double.d3

import com.github.ked4ma.atcoder.utils.debug.*

fun sized3DDoubleArray(row: Long, col: Long, dep: Long, default: Double): Array<Array<DoubleArray>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { DoubleArray(dep.toInt()) { default } } }
}

fun sized3DDoubleArray(row: Long, col: Long, dep: Long, default: () -> Double): Array<Array<DoubleArray>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { DoubleArray(dep.toInt()) { default.invoke() } } }
}
