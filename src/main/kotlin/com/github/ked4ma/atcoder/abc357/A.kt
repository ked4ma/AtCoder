package com.github.ked4ma.atcoder.abc357

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val H = nextIntList()

    var rem = M
    var ans = 0
    for (h in H) {
        if (h > rem) break
        rem -= h
        ans++
    }
    println(ans)
}
