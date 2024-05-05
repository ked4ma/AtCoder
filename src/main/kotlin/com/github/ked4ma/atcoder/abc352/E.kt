package com.github.ked4ma.atcoder.abc352

import com.github.ked4ma.atcoder.utils.array.any.d1.*
import com.github.ked4ma.atcoder.utils.array.boolean.d1.*
import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.models.unionfind.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) {
        mutableListOf<Pair<Int, Long>>()
    }
    val uf = UnionFind(N)
    repeat(M) {
        val (_, C) = nextLongList()
        val A = nextIntList()
        val a0 = A[0] - 1
        for (i in 1 until A.size) {
            val ai = A[i] - 1
            G[a0].add(ai to C)
            G[ai].add(a0 to C)
            uf.unite(a0, ai)
        }
    }

    if (uf.categories.toSet().size > 1) {
        println(-1)
        return
    }

    val marked = sizedBooleanArray(N)
    var markedCount = 0
    marked[0] = true
    markedCount++

    val queue = PriorityQueue<Pair<Int, Long>>(compareBy { (_, c) -> c })
    for ((i, c) in G[0]) {
        queue.offer(i to c)
    }

    var ans = 0L
    while (markedCount < N && queue.isNotEmpty()) {
        val (i, c) = queue.poll()
        if (marked[i]) continue
        marked[i] = true
        markedCount++

        ans += c

        for (next in G[i]) {
            queue.offer(next)
        }
    }

    println(if (markedCount == N) ans else -1)
}