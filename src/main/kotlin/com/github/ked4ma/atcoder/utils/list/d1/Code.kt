package com.github.ked4ma.atcoder.utils.list.d1

import com.github.ked4ma.atcoder.utils.debug.*

inline fun <reified T> sizedListOf(n: Long, default: T): List<T> {
    _debug_require(n in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return List(n.toInt()) { default }
}

inline fun <reified T> sizedListOf(n: Long, default: (Long) -> T): List<T> {
    _debug_require(n in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return List(n.toInt()) { index -> default(index.toLong()) }
}
