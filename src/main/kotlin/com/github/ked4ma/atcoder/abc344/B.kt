package com.github.ked4ma.atcoder.abc344

import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val list = mutableListOf<Int>()
    while (true) {
        val n = nextInt()
        list.add(n)
        if (n == 0) break
    }
    list.asReversed().forEach {
        println(it)
    }
}