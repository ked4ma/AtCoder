package com.github.ked4ma.atcoder.abc324

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, T) = nextList().let { (N, T) -> N.toInt() to T }
    val A = sizedArray(N, 0)
    val B = sizedArray(N, 0)
    val C = sizedArray(T.length + 1, 0)
    repeat(N) {
        val S = next()
        var a = 0
        var b = 0
        for (i in S.indices) {
            if (a < T.length && S[i] == T[a]) a++
            if (b < T.length && S[S.lastIndex - i] == T[T.lastIndex - b]) b++
        }
        A[it] = a
        B[it] = b
        C[B[it]]++
    }
    // cumulate from end
    for (i in C.lastIndex - 1 downTo 0) {
        C[i] += C[i + 1]
    }
    var ans = 0L
    for (a in A) {
        val l = T.length - a
        ans += C[l]
    }
    println(ans)
}