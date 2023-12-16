package com.github.ked4ma.atcoder.utils2.list

import com.github.ked4ma.atcoder.utils.debug.*

// ## List
operator fun <T> List<T>.get(index: Long): T {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}
