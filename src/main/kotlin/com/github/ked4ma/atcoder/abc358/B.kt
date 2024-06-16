package com.github.ked4ma.atcoder.abc358

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, A) = nextIntList()
    val T = nextIntList()
    var ans = 0
    for (t in T) {
        if (ans < t) {
            ans = t
        }
        ans += A
        println(ans)
    }
}
