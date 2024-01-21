package com.github.ked4ma.atcoder.abc337

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val S = next()
    val reg = "^A*B*C*$".toRegex()
    println(if (S.matches(reg)) "Yes" else "No")
}