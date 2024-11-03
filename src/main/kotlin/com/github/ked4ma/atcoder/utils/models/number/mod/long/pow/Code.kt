package com.github.ked4ma.atcoder.utils.models.number.mod.long.pow

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.models.number.mod.long.*

fun ModLong.pow(n: Int): ModLong = this.pow(n.toLong())
fun ModLong.pow(n: Long): ModLong {
    val mod = this.mod
    _debug_require(n >= 0) { "n($n) must be greater than or equal to zero(0)." }
    var res = 1L.toModLong(mod)
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