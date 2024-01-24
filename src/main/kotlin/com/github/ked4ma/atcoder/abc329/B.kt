package com.github.ked4ma.atcoder.abc329

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    println(A.distinct().sortedDescending()[1])
}