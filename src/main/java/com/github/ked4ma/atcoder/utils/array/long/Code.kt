package com.github.ked4ma.atcoder.utils.array.long

import com.github.ked4ma.atcoder.utils.debug.*

fun sizedLongArray(row: Long, default: Long): LongArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return LongArray(row.toInt()) { default }
}

fun sizedLongArray(row: Long, default: () -> Long): LongArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return LongArray(row.toInt()) { default.invoke() }
}

fun sized2DLongArray(row: Long, col: Long, default: Long): Array<LongArray> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { LongArray(col.toInt()) { default } }
}

fun sized2DLongArray(row: Long, col: Long, default: () -> Long): Array<LongArray> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { LongArray(col.toInt()) { default.invoke() } }
}

fun sized3DLongArray(row: Long, col: Long, dep: Long, default: Long): Array<Array<LongArray>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { LongArray(dep.toInt()) { default } } }
}

fun sized3DLongArray(row: Long, col: Long, dep: Long, default: () -> Long): Array<Array<LongArray>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { LongArray(dep.toInt()) { default.invoke() } } }
}

// accessor to get with long index
operator fun LongArray.get(index: Long): Long {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun LongArray.set(index: Long, value: Long) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
