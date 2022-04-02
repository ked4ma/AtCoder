package com.github.ked4ma.atcoder.abc189_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (N, X) = nextLongList().let { (N, X) -> N to X * 100 }
    var x = 0L
    for (i in 1..N) {
        val (v, p) = nextLongList()
        x += v * p
        if (x > X) {
            println(i)
            return
        }
    }
    println(-1)
}
