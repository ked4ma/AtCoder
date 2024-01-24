package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val arr = sizedArray(4) { 1L }
    arr[3] = Long.MAX_VALUE
    repeat(N - 1) {
        var i = 0
        while (arr[i] == arr[i + 1]) {
            i++
        }
        arr[i]++
        repeat(i) { j ->
            arr[j] = 1
        }
    }
    println(times(3) { it: Int ->
        "1".repeat(arr[it].toInt()).toLong()
    }.sum())
}