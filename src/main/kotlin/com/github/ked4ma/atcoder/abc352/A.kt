package com.github.ked4ma.atcoder.abc352

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, Y, Z) = nextIntList()
    println(if (Z in min(X, Y) ..max(X,Y)) "Yes" else "No")
}
