package com.github.ked4ma.atcoder.abc172

import com.github.ked4ma.atcoder.utils.*

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
