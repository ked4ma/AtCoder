package com.github.ked4ma.atcoder.utils2.math.matrix.long.pow

import com.github.ked4ma.atcoder.utils2.debug.*
import com.github.ked4ma.atcoder.utils2.math.matrix.long.times.*

fun Array<LongArray>.pow(k: Long): Array<LongArray> {
    _debug_require(k >= 0L) { "k($k) must be larger than or equals to zero(0)." }
    val h = this.size
    val w = this.first().size
    _debug_require(h == w) { "matrix($h, $w) must be square." }
    // E
    var res = Array(h) { LongArray(w) { 0L } }.apply {
        for (i in 0 until h) {
            this[i][i] = 1L
        }
    }
    var i = k
    var m = this
    while (i > 0) {
        if (i and 1L == 1L) {
            res *= m
        }
        m *= m
        i = i shr 1
    }
    return res
}
