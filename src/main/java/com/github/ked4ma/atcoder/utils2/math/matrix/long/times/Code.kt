package com.github.ked4ma.atcoder.utils2.math.matrix.long.times

import com.github.ked4ma.atcoder.utils.debug.*

operator fun Array<LongArray>.times(other: Array<LongArray>): Array<LongArray> {
    val r1 = this.size
    val c1 = this.first().size
    val r2 = other.size
    val c2 = other.first().size
    _debug_require(c1 == r2) { "col length of this and row length of other must be same" }
    val res = Array(r1) { LongArray(c2) { 0L } }
    for (i in 0 until r1) {
        for (j in 0 until c2) {
            for (k in 0 until c1) {
                res[i][j] += this[i][k] * other[k][j]
            }
        }
    }
    return res
}
