package com.github.ked4ma.atcoder.hhkb2020

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val n = nextInt()
    val p = nextIntList()
    val memo = mutableSetOf<Int>()
    var v = 0
    repeat(n) {
        memo.add(p[it])
        while (v in memo) {
            v++
        }
        println(v)
    }
}
