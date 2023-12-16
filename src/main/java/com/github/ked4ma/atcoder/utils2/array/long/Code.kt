package com.github.ked4ma.atcoder.utils2.array.long

import com.github.ked4ma.atcoder.utils.debug.*

// accessor to get with long index
operator fun LongArray.get(index: Long): Long {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun LongArray.set(index: Long, value: Long) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
