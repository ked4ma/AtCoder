package com.github.khronos227.atcoder.abc192

import com.github.khronos227.atcoder.utils.*

fun main() {
    val X = next().toCharArray().map { it - '0' }.asReversed()
    val M = nextLong()

    val d = X.sortedDescending()[0] + 1L
    _debug_println(d)

    fun getBaseNumber(base: Long): Long {
        var n = 0L
        var b = 1L
        X.forEach {
            // overflow
            if (b < 0 || b * it < 0 || Long.MAX_VALUE - n < b * it) return Long.MAX_VALUE

            n += b * it
            if (Long.MAX_VALUE / b < base) {
                b = -1
            } else {
                b *= base
            }
        }
        return n
    }

    _debug_println(getBaseNumber(d))
    if (getBaseNumber(d) > M) {
        println(0)
        return
    }
    if (X.size == 1) {
        println(1)
        return
    }

    var l = d
    var r = Long.MAX_VALUE / 2
    while (l + 1 < r) {
        val mid = (l + r) / 2
        _debug_println("$mid ${getBaseNumber(mid)}")
        if (getBaseNumber(mid) <= M) {
            l = mid
        } else {
            r = mid
        }
    }
    _debug_println("$l $r")
    _debug_println(getBaseNumber(l))
    println(l - d + 1)
}
