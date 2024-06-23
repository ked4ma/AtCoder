package com.github.ked4ma.atcoder.abc359

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var ans = 0
    repeat(N) {
        if (next() == "Takahashi") {
            ans++
        }
    }
    println(ans)
}
