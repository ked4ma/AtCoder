package com.github.ked4ma.atcoder.abc369

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    if (N == 1) {
        println(1)
        return
    }
    var i = 0
    var j = 1
    var ans = 0L
    while (i < N - 1) {
        while (j + 1 < N && A[j + 1] - A[j] == A[j] - A[j - 1]) {
            j++
        }
        _debug_println("$i -> $j")
        ans += ((j - i + 1) + 1L) * (j - i + 1L) / 2
        if (i > 0) {
            ans--
        }
        i = j
        j = i + 1
    }
    println(ans)
}
