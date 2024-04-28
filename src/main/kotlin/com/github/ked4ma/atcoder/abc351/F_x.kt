package com.github.ked4ma.atcoder.abc351

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val B = A.sorted().distinct()
    val M = B.size

    val sum0 = FenwickTree(M)
    val sum1 = FenwickTree(M)

    var ans = 0L
    for (i in N - 1 downTo 0) {
        val k = B.binarySearch(A[i])
        val c = sum0.sum(k, M)
        val s = sum1.sum(k, M)
        ans += s - c * A[i]
        sum0.add(k, 1)
        sum1.add(k, A[i])
    }
    println(ans)
}
