package com.github.ked4ma.atcoder.abc333

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.array.default.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val arr = sizedArray(4) { 1L }
    arr[3] = Long.MAX_VALUE
    loop(N - 1) {
        var i = 0L
        while (arr[i] == arr[i + 1]) {
            i++
        }
        arr[i]++
        loop(i) { j ->
            arr[j] = 1
        }
    }
    println(times(3) {
        "1".repeat(arr[it].toInt()).toLong()
    }.sum())
}