package com.github.ked4ma.atcoder.abc376

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

fun main() {
    val N = nextInt()
    val A = nextIntList().sortedDescending()
    val B = nextIntList().sortedDescending() + 0

    var rack = 0
    var ans = -1
    for (i in range(N)) {
        val a = A[i]
        if (a > B[i - rack]) {
            if (rack == 0) {
                rack++
                ans = a
            } else {
                println(-1)
                return
            }
        }
    }
    println(ans)
}
