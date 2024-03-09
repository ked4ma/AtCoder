package com.github.ked4ma.atcoder.abc344

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println(S.split("|").let { it[0] + it[2] })
}