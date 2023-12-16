package com.github.ked4ma.atcoder.utils2.array.any

import com.github.ked4ma.atcoder.utils2.debug.*

// accessor to get with long index
operator fun <T> Array<T>.get(index: Long): T {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun <T> Array<T>.set(index: Long, value: T) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
