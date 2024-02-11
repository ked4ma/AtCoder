package com.github.ked4ma.atcoder.abc340

import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.StringJoiner

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B, D) = nextIntList()

    val sj = StringJoiner(" ")
    var n = A
    while (n <= B) {
        sj.add(n.toString())
        n += D
    }
    println(sj)
}