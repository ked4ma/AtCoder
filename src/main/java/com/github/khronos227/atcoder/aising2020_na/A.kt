package com.github.khronos227.atcoder.aising2020_na

fun main() {
    val (l, r, d) = nextIntList()
    println(r.div(d).minus(l.minus(1).div(d)))
}
