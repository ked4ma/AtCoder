package com.github.ked4ma.atcoder.abc374

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println(if (S.takeLast(3) == "san") "Yes" else "No")
}
