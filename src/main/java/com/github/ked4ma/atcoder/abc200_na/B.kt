package com.github.ked4ma.atcoder.abc200_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (N, K) = nextIntList()
    var res = N.toLong()
    repeat(K) {
        if (res % 200 == 0L) {
            res /= 200
        } else {
            res = res * 1000 + 200
        }
    }
    println(res)
}
