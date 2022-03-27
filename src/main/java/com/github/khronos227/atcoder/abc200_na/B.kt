package com.github.khronos227.atcoder.abc200_na

import com.github.khronos227.atcoder.utils.*

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
