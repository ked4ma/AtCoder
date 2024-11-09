package com.github.ked4ma.atcoder.abc379

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = nextCharArray()
    var cnt = 0
    var ans = 0
    for (c in S) {
        if (c == 'O') {
            cnt++
        } else {
            cnt = 0
        }
        if (cnt == K) {
            ans++
            cnt = 0
        }
    }
    println(ans)
}
