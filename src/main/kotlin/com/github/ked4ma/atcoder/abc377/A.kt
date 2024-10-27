package com.github.ked4ma.atcoder.abc377

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next().toList().sorted().joinToString("")
    println(if (S == "ABC") "Yes" else "No")
}
