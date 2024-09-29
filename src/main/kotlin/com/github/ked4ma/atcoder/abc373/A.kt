package com.github.ked4ma.atcoder.abc373

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var ans = 0
    repeat(12) { i ->
        val S = next()
        if (S.length == i + 1) ans++
    }
    println(ans)
}
