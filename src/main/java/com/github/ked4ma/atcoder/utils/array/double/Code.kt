package com.github.ked4ma.atcoder.utils.array.double

import com.github.ked4ma.atcoder.utils.debug.*

// accessor to get with long index
operator fun DoubleArray.get(index: Long): Double {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun DoubleArray.set(index: Long, value: Double) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
