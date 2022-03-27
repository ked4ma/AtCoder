package com.github.khronos227.atcoder.abc200_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val N = nextInt()
    val A = nextIntList()
    val rems = LongArray(200) { 0 }

    var res = 0L
    for (i in 0 until N) {
        val r = A[i] % 200
        res += rems[r]++
    }

    println(res)
}
