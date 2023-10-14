package com.github.ked4ma.atcoder.abc324

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = next().toCharArray().sortedDescending()
    val B = A.joinToString("").toLong()

    var ans = 0L
    var n = 0L
    while (n.pow(2) <= B) {
        val C = String.format("%0${N}d", n.pow(2)).toCharArray().sortedDescending()
        var i = 0
        while (i < A.size && A[i] == C[i]) {
            i++
        }
        if (i == A.size) ans++
        n++
    }
    println(ans)
}