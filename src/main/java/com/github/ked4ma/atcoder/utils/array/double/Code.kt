package com.github.ked4ma.atcoder.utils.array.double

import com.github.ked4ma.atcoder.utils.debug.*

fun sizedDoubleArray(row: Long, default: Double): DoubleArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return DoubleArray(row.toInt()) { default }
}

fun sizedDoubleArray(row: Long, default: () -> Double): DoubleArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return DoubleArray(row.toInt()) { default.invoke() }
}

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

// accessor to get with long index
operator fun DoubleArray.get(index: Long): Double {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun DoubleArray.set(index: Long, value: Double) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
