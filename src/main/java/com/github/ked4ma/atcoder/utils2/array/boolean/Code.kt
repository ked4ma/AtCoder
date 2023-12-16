package com.github.ked4ma.atcoder.utils2.array.boolean

import com.github.ked4ma.atcoder.utils.debug.*

// accessor to get with long index
operator fun BooleanArray.get(index: Long): Boolean {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun BooleanArray.set(index: Long, value: Boolean) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
