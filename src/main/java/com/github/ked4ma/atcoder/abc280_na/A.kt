package com.github.ked4ma.atcoder.abc280_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextLongList()
    times(H) {
        next().count { it == '#' }
    }.sum().let {
        println(it)
    }
}