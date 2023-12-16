package com.github.ked4ma.atcoder.utils.array.long.d1

import com.github.ked4ma.atcoder.utils.debug.*

fun sizedLongArray(row: Long, default: Long): LongArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return LongArray(row.toInt()) { default }
}

fun sizedLongArray(row: Long, default: () -> Long): LongArray {
    _debug_require(row in 0..Int.MAX_VALUE.toLong()) { "row must be within Int range (0 to ${Int.MAX_VALUE})" }
    return LongArray(row.toInt()) { default.invoke() }
}
