package com.github.ked4ma.atcoder.abc356

import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val B = sizedIntArray(M, 0)
    repeat(N) {
        val X = nextIntList()
        for (i in range(M)) {
            B[i] += X[i]
        }
    }
    val ok = range(M).all {
        B[it] >= A[it]
    }
    println(if (ok) "Yes" else "No")
}
