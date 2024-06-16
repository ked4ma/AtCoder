package com.github.ked4ma.atcoder.abc358

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextLongList().sorted() // len: N
    val B = nextLongList().sorted() // len: M
    _debug_println(A)
    _debug_println(B)

    var ans = 0L
    var i = 0
    for (b in B) {
        while (i < A.size && A[i] < b) {
            i++
        }
        if (i >= A.size) {
            println(-1)
            return
        }
        ans += A[i]
        i++
    }
    println(ans)
}
