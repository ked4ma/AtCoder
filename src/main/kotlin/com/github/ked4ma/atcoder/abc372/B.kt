package com.github.ked4ma.atcoder.abc372

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.int.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var M = nextInt()
    var a = 10
    val list = mutableListOf<Int>()
    while (M > 0) {
        while (a > 0 && 3.pow(a) > M) {
            a--
        }
        M -= 3.pow(a)
        list.add(a)
    }
    println(list.size)
    println(list.joinToString(" "))
}
