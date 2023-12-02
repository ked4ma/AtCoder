package com.github.ked4ma.atcoder.abc331

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (M, D) = nextLongList()
    var (y, m, d) = nextLongList()
    d++
    var car = false
    if (d > D) {
        car = true
        d -= D
    }
    if (car) {
        m++
    }
    car = false
    if (m > M) {
        car  = true
        m -= M
    }
    if (car) {
        y++
    }
    println("$y $m $d")
}