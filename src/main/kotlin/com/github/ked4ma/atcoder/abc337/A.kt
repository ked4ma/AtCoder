package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val (X, Y) = timesWithLong(N) {
        val (x, y) = nextLongList()
        x to y
    }.unzip()
    val sX = X.sum()
    val sY = Y.sum()
    if (sX == sY) {
        println("Draw")
    } else if (sX > sY) {
        println("Takahashi")
    } else {
        println("Aoki")
    }
}