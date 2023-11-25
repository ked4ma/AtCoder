package com.github.ked4ma.atcoder.abc327

import com.github.ked4ma.atcoder.utils.array.deprecated.*
import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

// make run <TASK: A/B/...> [BRANCH=feature/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val B = nextIntList()
    val X = sizedArray(N + 1, -1)
    val AB = A.zip(B).flatMap {
        listOf(
            it,
            it.second to it.first
        )
    }.toSet()
    val link = AB.groupBy { it.first }
    val queue = ArrayDeque<Pair<Int, Int>>()
    for (ab in AB) {
        queue.add(ab)
        while (queue.isNotEmpty()) {
            val (a, b) = queue.removeFirst()
            if (a == b) {
                println("No")
                return
            } else if (X[a] != -1 && X[b] != -1 && X[a] == X[b]) {
                println("No")
                return
            } else if (X[a] == -1 && X[b] == -1) {
                X[a] = 0
                X[b] = 1
            } else if (X[a] == -1) {
                X[a] = 1 - X[b]
            } else if (X[b] == -1) {
                X[b] = 1 - X[a]
            } else {
                continue
            }
            _debug_println("$a $b ${X.toList()}")
            queue.addAll(link.getValue(a))
            queue.addAll(link.getValue(b))
        }
    }
    println("Yes")
}