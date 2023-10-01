package com.github.ked4ma.atcoder.aising2020_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val (l, r, d) = nextIntList()
    println(r.div(d).minus(l.minus(1).div(d)))
}
