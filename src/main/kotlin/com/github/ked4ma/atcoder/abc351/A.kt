package com.github.ked4ma.atcoder.abc351

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = nextIntList()
    val B = nextIntList()
    println(A.sum() - B.sum() + 1)
}
