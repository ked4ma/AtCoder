package com.github.ked4ma.atcoder.abc327

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    println(if ("ab" in S || "ba" in S) "Yes" else "No")
}