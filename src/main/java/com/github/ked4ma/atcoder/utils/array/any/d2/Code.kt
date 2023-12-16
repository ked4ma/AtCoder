package com.github.ked4ma.atcoder.utils.array.any.d2

import com.github.ked4ma.atcoder.utils.debug.*

inline fun <reified T> sized2DArray(row: Long, col: Long, default: T): Array<Array<T>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { default } }
}

inline fun <reified T> sized2DArray(row: Long, col: Long, default: () -> T): Array<Array<T>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { default.invoke() } }
}
