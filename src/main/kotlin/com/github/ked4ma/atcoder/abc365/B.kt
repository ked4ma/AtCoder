package com.github.ked4ma.atcoder.abc365

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var i1: Int
    var i2: Int
    if (A[0] > A[1]) {
        i1 = 0
        i2 = 1
    } else {
        i1 = 1
        i2 = 0
    }
    for (i in 2 until N) {
        if (A[i] > A[i1]) {
            i2 = i1
            i1 = i
        } else if (A[i] > A[i2]) {
            i2 = i
        }
    }
    println(i2 + 1)
}
