package com.github.ked4ma.atcoder.utils.array.long.d3

import com.github.ked4ma.atcoder.utils.debug.*

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
