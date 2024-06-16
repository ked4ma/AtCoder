package com.github.ked4ma.atcoder.abc358

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (S, T) = nextList()
    println(if (S == "AtCoder" && T == "Land") "Yes" else "No")
}
