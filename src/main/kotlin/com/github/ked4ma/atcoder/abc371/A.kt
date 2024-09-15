package com.github.ked4ma.atcoder.abc371

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextList()
    val arr = sizedIntArray(3, 0)
    if (S[0] == "<") {
        arr[1]++
    } else {
        arr[0]++
    }
    if (S[1] == "<") {
        arr[2]++
    } else {
        arr[0]++
    }
    if (S[2] == "<") {
        arr[2]++
    } else {
        arr[1]++
    }
    println(
        when (arr.indexOf(1)) {
            0 -> "A"
            1 -> "B"
            else -> "C"
        }
    )
}
