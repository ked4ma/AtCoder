package com.github.khronos227.atcoder.abc046_na

import kotlin.math.max

fun main() {
    var nt = 1L
    var na = 1L
    repeat(nextInt()) {
        val (t, a) = nextIntList()
        val r = max(
            nt / t + (if (nt % t == 0L) 0 else 1),
            na / a + (if (na % a == 0L) 0 else 1)
        )
        // 丸め誤差 щ(ﾟдﾟщ)
        // val r = ceil(
        //   max(
        //     nt.toDouble() / t,
        //     na.toDouble() / a
        //   )
        // ).toLong()
        nt = t * r
        na = a * r
    }
    println(nt + na)
}
