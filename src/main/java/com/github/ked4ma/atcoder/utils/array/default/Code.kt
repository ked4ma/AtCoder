package com.github.ked4ma.atcoder.utils.array.default

import com.github.ked4ma.atcoder.utils.debug.*

// ## Array
inline fun <reified T> sizedArray(size: Long, default: T): Array<T> {
    _debug_require(size in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(size.toInt()) { default }
}

inline fun <reified T> sizedArray(size: Long, default: () -> T): Array<T> {
    _debug_require(size in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(size.toInt()) { default.invoke() }
}

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
