package com.github.ked4ma.atcoder.abc367

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B, C) = nextIntList()
    var h = B
    var available = false
    repeat(24) {
        var h = (h + it) % 24
        if (h == C) available = true
        if (h == A && available) {
            println("Yes")
            return
        }
    }
    println("No")
}
