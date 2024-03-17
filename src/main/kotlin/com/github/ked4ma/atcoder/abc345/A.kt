package com.github.ked4ma.atcoder.abc345

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println(if ("<=+>".toRegex().matches(S)) "Yes" else "No")
}