package com.github.ked4ma.atcoder.abc359

import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val arr = sizedBooleanArray(N)
    for (i in range(2 * N - 2)) {
        if (A[i] == A[i + 2]) arr[A[i] - 1] = true
    }
    println(arr.count { it })
}
