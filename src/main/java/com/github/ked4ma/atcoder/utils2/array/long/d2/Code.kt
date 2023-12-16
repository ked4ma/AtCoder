package com.github.ked4ma.atcoder.utils2.array.long.d2

import com.github.ked4ma.atcoder.utils.debug.*

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
