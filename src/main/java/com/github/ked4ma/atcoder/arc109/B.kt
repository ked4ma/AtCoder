package com.github.ked4ma.atcoder.arc109

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.sqrt

fun main() {
    val n = nextLong()

    var l = 0L
    var r = n

    sqrt((1 + 8 * (n + 1)).toDouble()).let {
//        println(((-1 + it) / 2).toLong())
//        println(n + 1 - ((-1 + it) / 2).toLong())
        r = ((-1 + it) / 2).toLong() * 2
    }

    while (l != r) {
        val mid = (l + r + 1) / 2
        val c = mid * (mid + 1)
        if (c <= 2 * n + 2) {
            l = mid
        } else {
            r = mid - 1
        }
//        println("$l $r ${(n + 1) * n / 2} ${(n + 2) * (n + 1) / 2} ${mid * (mid + 1) / 2} $mid ${c <= 2 * n + 2}")
    }
//    println(l)
    println(n + 1 - l)
}
