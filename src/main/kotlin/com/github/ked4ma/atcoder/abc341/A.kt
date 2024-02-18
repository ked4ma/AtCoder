package com.github.ked4ma.atcoder.abc341

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val sb = StringBuilder()
    sb.append(1)
    repeat(N) {
        sb.append("01")
    }
    println(sb)
}