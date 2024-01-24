package com.github.ked4ma.atcoder.utils.array.any.d1

import com.github.ked4ma.atcoder.utils.debug.*

inline fun <reified T> sizedArray(size: Long, default: T): Array<T> {
    _debug_require(size in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(size.toInt()) { default }
}

inline fun <reified T> sizedArray(size: Long, default: () -> T): Array<T> {
    _debug_require(size in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return Array(size.toInt()) { default.invoke() }
}
