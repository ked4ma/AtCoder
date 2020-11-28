package com.github.khronos227.atcoder.abc051_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (k, s) = nextIntList()
    var count = 0
    x@ for (x in (0..k)) {
        y@ for (y in (0..k)) {
            val z = s - x - y
            if (z < 0) break@y
            if (z in (0..k)) {
                count++
            }
        }
    }
    println(count)
}
