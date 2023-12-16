package com.github.ked4ma.atcoder.utils2.math.matrix.long.mod

import com.github.ked4ma.atcoder.utils2.debug.*

fun Array<LongArray>.powMod(k: Long, mod: Long): Array<LongArray> {
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
            res = res.timesMod(m, mod)
        }
        m = m.timesMod(m, mod)
        i = i shr 1
    }
    return res
}

fun Array<LongArray>.timesMod(other: Array<LongArray>, mod: Long): Array<LongArray> {
    val r1 = this.size
    val c1 = this.first().size
    val r2 = other.size
    val c2 = other.first().size
    _debug_require(c1 == r2) { "col length of this and row length of other must be same" }
    val res = Array(r1) { LongArray(c2) { 0L } }
    for (i in 0 until r1) {
        for (j in 0 until c2) {
            for (k in 0 until c1) {
                res[i][j] = (res[i][j] + (this[i][k] * other[k][j])) % mod
            }
        }
    }
    return res
}
