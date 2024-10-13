package com.github.ked4ma.atcoder.abc375

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    var ans = 0
    for (i in range(N - 2)) {
        if (S[i] == '#' && S[i + 1] == '.' && S[i + 2] == '#') {
            ans++
        }
    }
    println(ans)
}
