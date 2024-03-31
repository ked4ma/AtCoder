package com.github.ked4ma.atcoder.abc347

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    buildSet {
        for (i in range(S.length)) {
            for (j in i + 1..S.length) {
                add(S.substring(i, j))
            }
        }
    }.size.let {
        println(it)
    }
}