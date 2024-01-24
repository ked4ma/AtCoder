package com.github.ked4ma.atcoder.utils.array.boolean.d2

import com.github.ked4ma.atcoder.utils.debug.*

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
