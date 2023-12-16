package com.github.ked4ma.atcoder.utils.array.boolean.d3

import com.github.ked4ma.atcoder.utils.debug.*

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
