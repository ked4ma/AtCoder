package com.github.ked4ma.atcoder.abc367

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = next()
    var i = X.lastIndex
    while (X[i] == '0') {
        i--
    }
    if (X[i] == '.') {
        i--
    }
    println(X.substring(0..i))
}
