package com.github.ked4ma.atcoder.utils.array.char

import com.github.ked4ma.atcoder.utils.debug.*

// accessor to get with long index
operator fun CharArray.get(index: Long): Char{
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}

// accessor to set with long index
operator fun CharArray.set(index: Long, value: Char) {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    set(index.toInt(), value)
}
