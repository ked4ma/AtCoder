package com.github.ked4ma.atcoder.abc329

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = next().toCharArray()
    val T = next().toCharArray()
    val queue = ArrayDeque<Int>()
    val used = sizedArray(N + 1, false)
    fun check(index: Int) {
        if (used[index]) return
        val ok = (0 until M).all { i -> S[index + i] == '#' || S[index + i] == T[i] }
        if (ok) {
            used[index] = true
            queue.addLast(index)
        }
    }
    // init
    for (i in 0..N - M) {
        check(i)
    }
    while (queue.isNotEmpty()) {
        val index = queue.removeFirst()
        for (i in 0 until M) {
            S[index + i] = '#'
        }
        for (i in (index - M + 1).coerceAtLeast(0)..(index + M - 1).coerceAtMost(N - M)) {
            check(i)
        }
    }
    println(if (S.all { it == '#' }) "Yes" else "No")
}