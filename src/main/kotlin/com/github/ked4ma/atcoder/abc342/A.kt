package com.github.ked4ma.atcoder.abc342

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val a = S[0]
    val b = S[1]
    if (S[0] == S[1]) {
        for (i in 2 until S.length) {
            if (S[i] != S[0]) {
                println(i + 1)
                return
            }
        }
    } else {
        for (i in 2 until S.length) {
            if (S[i] != S[0]) {
                println(1)
                return
            } else if (S[i] != S[1]) {
                println(2)
                return
            }
        }
    }
}