package com.github.ked4ma.atcoder.abc338

import com.github.ked4ma.atcoder.utils.input.default.*


// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    if (S[0] !in 'A'..'Z') {
        println("No")
        return
    }
    for (i in 1 until S.length) {
        if (S[i] !in 'a' .. 'z') {
            println("No")
            return
        }
    }
    println("Yes")
}