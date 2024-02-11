package com.github.ked4ma.atcoder.abc340

import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.array.int.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = sizedLongArray(N - 1, 0L)
    val B = sizedLongArray(N - 1, 0L)
    val X = sizedIntArray(N - 1, 0)
    repeat(N - 1) {
        val (a, b, x) = nextLongList()
        A[it] = a
        B[it] = b
        X[it] = x.toInt() - 1
    }
    val cost = sizedLongArray(N, Long.MAX_VALUE)
    cost[0] = 0

    val visited = sizedBooleanArray(N, false)
    val queue = PriorityQueue<Pair<Int, Long>> { a, b ->
        a.second.compareTo(b.second)
    }
    queue.add(0 to 0)
    while (queue.isNotEmpty()) {
        val (s, c) = queue.poll()
        if (visited[s]) continue
        visited[s] = true
        cost[s] = c
        if (s < N - 1) {
            queue.offer(s + 1 to c + A[s])
            queue.offer(X[s] to c + B[s])
        }
    }
    println(cost.last())
}