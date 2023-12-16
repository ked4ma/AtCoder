package com.github.ked4ma.atcoder.utils2.array.boolean.d1

import com.github.ked4ma.atcoder.utils2.debug.*

fun sizedBooleanArray(row: Long, default: Boolean): BooleanArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return BooleanArray(row.toInt()) { default }
}

fun sizedBooleanArray(row: Long, default: () -> Boolean): BooleanArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return BooleanArray(row.toInt()) { default.invoke() }
}
