package com.github.ked4ma.atcoder.utils2.math.long.pow

import com.github.ked4ma.atcoder.utils.debug.*

fun Long.pow(n: Long): Long {
    _debug_require(n < 0) { "n($n) must be greater than or equal to zero(0)." }
    var res = 1L
    var i = n
    var m = this
    while (i > 0L) {
        if (i and 1L == 1L) {
            res *= m
        }
        m *= m
        i = i shr 1
    }
    return res
}
