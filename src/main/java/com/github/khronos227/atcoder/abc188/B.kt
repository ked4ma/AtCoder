package com.github.khronos227.atcoder.abc188

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextInt()
    val A = nextIntList()
    val B = nextIntList()
    var sum = 0L
    repeat(N) {
        sum += A[it] * B[it]
    }
    println(if (sum == 0L) "Yes" else "No")
}
