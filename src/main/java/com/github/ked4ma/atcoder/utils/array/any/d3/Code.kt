package com.github.ked4ma.atcoder.utils.array.any.d3

import com.github.ked4ma.atcoder.utils.debug.*

inline fun <reified T> sized3DArray(row: Long, col: Long, dep: Long, default: T): Array<Array<Array<T>>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { Array(dep.toInt()) { default } } }
}

inline fun <reified T> sized3DArray(row: Long, col: Long, dep: Long, default: () -> T): Array<Array<Array<T>>> {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(col in 0..Int.MAX_VALUE.toLong()) { "col must be within Int range (0 to ${Int.MAX_VALUE})" }
    _debug_require(dep in 0..Int.MAX_VALUE.toLong()) { "dep must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(row.toInt()) { Array(col.toInt()) { Array(dep.toInt()) { default.invoke() } } }
}
