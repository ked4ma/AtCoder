package com.github.ked4ma.atcoder.abc371

import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val arr = sizedBooleanArray(N)
    repeat(M) {
        val (A, B) = nextList().let { (A, B) -> A.toInt() - 1 to B }
        if (B == "M" && !arr[A]) {
            println("Yes")
            arr[A] = true
        } else {
            println("No")
        }
    }
}
