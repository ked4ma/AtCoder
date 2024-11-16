package com.github.ked4ma.atcoder.abc380

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val ans = mutableListOf<Int>()
    var cnt = 0
    for (i in 1 until S.size) {
        if (S[i] == '-') {
            cnt++
        } else {
            ans.add(cnt)
            cnt = 0
        }
    }
    println(ans.joinToString(" "))
}
