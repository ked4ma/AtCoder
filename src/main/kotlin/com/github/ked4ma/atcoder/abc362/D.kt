package com.github.ked4ma.atcoder.abc362

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.long.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextLongList()

    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    repeat(M) {
        val (U, V, B) = nextIntList()
        G[U - 1].add(V - 1 to B.toLong())
        G[V - 1].add(U - 1 to B.toLong())
    }

    val ans = sizedLongArray(N, Long.MAX_VALUE)
    val queue = PriorityQueue<Pair<Int, Long>>(compareBy { it.second })
    queue.offer(0 to A[0])
    while (queue.isNotEmpty()) {
        val (u, c) = queue.poll()
        if (ans[u] < Long.MAX_VALUE) continue
        ans[u] = c
        for ((v, b) in G[u]) {
            queue.offer(v to c + A[v] + b)
        }
    }
    println(ans.slice(1 until N).joinToString(" "))
}
