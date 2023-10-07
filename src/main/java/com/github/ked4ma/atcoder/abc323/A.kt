package com.github.ked4ma.atcoder.abc323

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val S = next()
    for (i in (1..S.lastIndex step 2)) {
        if (S[i] == '1') {
            println("No")
            return
        }
    }
    println("Yes")
}