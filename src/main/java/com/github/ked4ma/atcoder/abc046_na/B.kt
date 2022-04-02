package com.github.ked4ma.atcoder.abc046_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (n, k) = nextIntList()
    var cnt = k.toLong()
    repeat((1 until n).count()) {
        cnt *= (k - 1)
    }
    println(cnt)
}
