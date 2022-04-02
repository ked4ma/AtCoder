package com.github.ked4ma.atcoder.abc193_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val N = nextInt()
    var min = 2_000_000_000
    repeat(N) {
        val (A, P, X) = nextIntList()
        if (X <= A) return@repeat
        if (min > P) {
            min = P
        }
    }
    println(if (min > 1_000_000_000) -1 else min)
}
