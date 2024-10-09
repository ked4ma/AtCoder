package com.github.ked4ma.atcoder.utils.math.div.ceil

// round up division
// e.g.  5 / 2 -> 3
//      19 / 5 -> 4
fun Int.ceilDiv(n: Int) = (this + n - 1) / n
fun Long.ceilDiv(n: Long) = (this + n - 1) / n
