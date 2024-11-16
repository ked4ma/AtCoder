package com.github.ked4ma.atcoder.abc380

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val arr = sizedIntArray(10, 0)
    for (c in S) {
        arr[c - '0']++
    }
    arr[1] -= 1
    arr[2] -= 2
    arr[3] -= 3
    println(if (arr.all { it == 0 }) "Yes" else "No")
}
