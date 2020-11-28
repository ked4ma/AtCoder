package com.github.khronos227.atcoder.abc172

import com.github.khronos227.atcoder.utils.*

fun main() {
    val s = next()
    val t = next()
    var res = 0
    (s.indices).forEach {
        if (s[it] != t[it]) {
            res++
        }
    }
}
