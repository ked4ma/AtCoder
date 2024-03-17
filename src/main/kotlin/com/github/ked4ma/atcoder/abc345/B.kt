package com.github.ked4ma.atcoder.abc345

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.ceil

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextLong()
    println(if (X % 10 == 0L){
        X / 10
    } else if (X < 0) {
        X / 10
    } else {
        X / 10 + 1
    })
}