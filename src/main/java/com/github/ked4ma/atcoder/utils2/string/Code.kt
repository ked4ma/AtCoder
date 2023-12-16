package com.github.ked4ma.atcoder.utils2.string

import com.github.ked4ma.atcoder.utils2.debug.*

fun String.length(): Long = this.length.toLong()
operator fun String.get(index: Long): Char {
    _debug_require(index in 0..Int.MAX_VALUE.toLong()) { "size must be within Int range (0 to ${Int.MAX_VALUE})" }
    return get(index.toInt())
}