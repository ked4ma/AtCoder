package com.github.khronos227.atcoder.abc196_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val S = next()
    val T = next()

    println(solveOnm(S, T))
}

fun solveOnm(s: String, t: String): Int {
    var res = Int.MAX_VALUE
    for (i in 0..s.length - t.length) {
        var count = 0
        for (j in t.indices) {
            if (s[i + j] != t[j]) count++
        }
        if (res > count) {
            res = count
        }
    }
    return res
}
