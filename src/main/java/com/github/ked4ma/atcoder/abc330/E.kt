package com.github.ked4ma.atcoder.abc330

import com.github.ked4ma.atcoder.utils.array.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.loop.*


// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextLongList()
    val A = nextLongList().toTypedArray()
    val bk = sizedArray(N + 1, 0L)
    A.forEach { a ->
        if (a <= N) {
            bk[a.toInt()]++
        }
    }
    val set = sortedSetOf<Long>()
    bk.forEachIndexed { i, count ->
        if (count == 0L) set.add(i.toLong())
    }
    _debug_println(set)
    repeat(Q) {
        val (i, x) = nextLongList().let { (i, x) -> i - 1 to x }
        if (A[i] <= N) {
            bk[A[i]]--
            if (bk[A[i]] == 0L) {
                set.add(A[i])
            }
        }
        A[i] = x
        if (x <= N) {
            bk[x]++
            set.remove(x)
        }
        _debug_println(set)
        println(set.first())
    }
}