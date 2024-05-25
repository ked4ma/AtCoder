package com.github.ked4ma.atcoder.abc355

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, T) = nextIntList()
    val A = nextIntList()
    val tate = sizedIntArray(N, 0)
    val yoko = sizedIntArray(N, 0)
    val naname = sizedIntArray(2, 0)
    for (t in range(T)) {
        val a = A[t] - 1
        val i = a / N
        val j = a % N
        yoko[i]++
        tate[j]++
        if (i == j) {
            naname[0]++
        }
        if (N - 1 - i == j) {
            naname[1]++
        }
        if (yoko[i] == N || tate[j] == N || naname[0] == N || naname[1] == N) {
            _debug_println(yoko.joinToString(","))
            _debug_println(tate.joinToString(","))
            _debug_println(naname.joinToString(","))
            println(t + 1)
            return
        }
    }
    println(-1)
}
