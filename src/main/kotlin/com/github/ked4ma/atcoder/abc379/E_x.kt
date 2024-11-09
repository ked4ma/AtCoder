package com.github.ked4ma.atcoder.abc379

import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()

    val arr = sizedLongArray(N, 0)
    for (i in range(N)) {
        arr[i] = (i + 1L) * (S[i] - '0')
    }
    for (i in 1 until N) {
        arr[i] += arr[i - 1]
    }
    var i = 0
    var c = 0L
    val ans = StringBuilder()
    while (i < N || c > 0) {
        if (i < N) {
            c += arr[N - i - 1]
        }
        ans.append(c % 10)
        c /= 10
        i++
    }
    println(ans.reversed())
}
