package com.github.ked4ma.atcoder.abc376

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, C) = nextIntList()
    val T = nextIntList()
    var pre = Int.MIN_VALUE / 2
    var ans = 0
    for (t in T) {
        if (t - pre >= C) {
            ans++
            pre = t
        }
    }
    println(ans)
}
