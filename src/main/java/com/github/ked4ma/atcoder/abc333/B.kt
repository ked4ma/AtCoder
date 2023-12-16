package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val S = next().toCharArray().map { it - 'A' }.sorted().let { (a, b) ->
        if (b - a == 1 || b - a == 4) 1 else 2
    }
    val T = next().toCharArray().map { it - 'A' }.sorted().let { (a, b) ->
        if (b - a == 1 || b - a == 4) 1 else 2
    }
    println(if (S == T) "Yes" else "No")
}