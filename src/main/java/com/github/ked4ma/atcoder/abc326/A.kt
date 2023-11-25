package com.github.ked4ma.atcoder.abc326

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (X, Y) = nextIntList()
    println(if (Y - X in (-3..2)) "Yes" else "No")
}