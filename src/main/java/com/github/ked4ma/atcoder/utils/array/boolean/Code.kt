package com.github.ked4ma.atcoder.utils.array.boolean

import com.github.ked4ma.atcoder.utils.debug.*

fun sizedBooleanArray(row: Long, default: Boolean): BooleanArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return BooleanArray(row.toInt()) { default }
}

fun sizedBooleanArray(row: Long, default: () -> Boolean): BooleanArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return BooleanArray(row.toInt()) { default.invoke() }
}

fun sized2DBooleanArray(row: Long, col: Long, default: Boolean): Array<BooleanArray> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { BooleanArray(col.toInt()) { default } }
}

fun sized2DBooleanArray(row: Long, col: Long, default: () -> Boolean): Array<BooleanArray> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { BooleanArray(col.toInt()) { default.invoke() } }
}

fun sized3DBooleanArray(row: Long, col: Long, dep: Long, default: Boolean): Array<Array<BooleanArray>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { BooleanArray(dep.toInt()) { default } } }
}

fun sized3DBooleanArray(row: Long, col: Long, dep: Long, default: () -> Boolean): Array<Array<BooleanArray>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { BooleanArray(dep.toInt()) { default.invoke() } } }
}

// accessor to get with long index
operator fun BooleanArray.get(index: Long): Boolean {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun BooleanArray.set(index: Long, value: Boolean) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
